package com.bone.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bone.domain.user.User;

import org.apache.commons.lang.StringUtils;


public class ViewSpaceFilter implements Filter {
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";

	// ① 需要登录即可访问的URI资源
	private static final String[] INHERENT_URIS = { "/basic"};
	
	   /**
	    * 用户对象放到Session中的键名称
	    */
	public static final String USER_CONTEXT = "USER_CONTEXT";
	   
	   /**
	    * 将登录前的URL放到Session中的键名称
	    */
	public static final String LOGIN_TO_URL = "toUrl";
	   
	// ② 执行过滤
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// ②-1 保证该过滤器在一次请求中只被调用一次
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		} else {

			// ②-2 设置过滤标识，防止一次请求多次过滤
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			User userContext = getSessionUser(httpRequest);

			// ②-3 用户未登录, 且当前URI资源需要登录才能访问
			if (userContext == null
					&& isURILogin(httpRequest.getRequestURI(), httpRequest)) {
				String toUrl = httpRequest.getRequestURL().toString();
				if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
					toUrl += "?" + httpRequest.getQueryString();
				}

				// ②-4将用户的请求URL保存在session中，用于登录成功之后，跳到目标URL
				//httpRequest.getSession().setAttribute(LOGIN_TO_URL, toUrl);

				// ②-5转发到登录页面
				httpResponse.sendRedirect(getPortalHostAddress(httpRequest)+"/bone/basic.html");
				return;
			}
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}
   /**
    * 当前URI资源是否需要登录才能访问
    * @param requestURI
    * @param request
    * @return
    */
	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		for (String uri : INHERENT_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >= 0) {
				return false;
			}
		}
		return true;
	}

	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(USER_CONTEXT);
	}
	
	private  String getPortalHostAddress(HttpServletRequest request){
    	//如果使用apache反向代理来分发请求从"X-FORWARDED-HOST"头取port主机地址
        String portalHost =  request.getHeader("X-FORWARDED-HOST");
        if(StringUtils.isBlank(portalHost)){//使用其他方式，如前后端部署在一个中间件上或用JK,AJP代理的方式apache与应用服务器连接
        	portalHost = request.getHeader("HOST");
        }
        return request.getScheme() + "://" + portalHost;
    }

	public void destroy() {

	}
}
