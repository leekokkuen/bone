package com.bone.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Title: 常用正则表达�?/p>
 * <p>Description: RegExpUtil</p>
 * <p>Copyright: Copyright © 2012</p>
 * <p>Company: Creativity Convention & Exhibition(shenzhen) Co.,td.</p>
 *
 * @author Vernon.Chen
 * @version 1.0 2012-12-27
 */
public class RegExpUtil {
	/**
	 * 邮编规则
	 */
	public static final String POST_CODE = "[1-9]\\d{5}(?!\\d)";

	/**
	 * 手机号规�?
	 */
	public static final String MOBILE_PHONE = "^[1]([0-9][0-9]{1}|59|58|88|89)[0-9]{8}$";

	/**
	 * 身份证检验规�?
	 */
	public static final String IDCARD = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65|71|81|82|91)\\d{4})((((19|20)(([02468][048])|([13579][26]))0229))|((20[0-9][0-9])|(19[0-9][0-9]))((((0[1-9])|(1[0-2]))((0[1-9])|(1\\d)|(2[0-8])))|((((0[1,3-9])|(1[0-2]))(29|30))|(((0[13578])|(1[02]))31))))((\\d{3}(x|X))|(\\d{4}))";

	/**
	 * 邮箱验证
	 */
	public static final String EMAIL = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";

	/**
	 * 全部是数�?
	 */
	public static final String NUM = "^[0-9]*$";

	/**
	 * 不能以数字开�?只是中文,英文,下划�?�?中划�?
	 */
	public static final String USER_NAME_EXP = "^[\u4E00-\u9FA5A-Za-z_.-][\u4E00-\u9FA5A-Za-z0-9_.-]+$";

	/**
	 * 是否满足正则表达�?
	 * 
	 * @param source 测试的字符穿
	 * @param regxp 正则表达�?
	 * @return
	 * @author Vernon.Chen
	 * @date 2012-12-27
	 */
	public static boolean matches(String source, String regxp) {
		Pattern regex = Pattern.compile(regxp);
		Matcher matcher = regex.matcher(source);
		return matcher.matches();
	}

}
