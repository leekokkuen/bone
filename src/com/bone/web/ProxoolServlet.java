package com.bone.web;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logicalcobwebs.proxool.ProxoolFacade;

import com.bone.tools.LogUtil;

public class ProxoolServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		super.destroy();
		Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
		while(drivers.hasMoreElements()){
			try {
				DriverManager.deregisterDriver(drivers.nextElement());
			} catch (SQLException e) {
				LogUtil.e(ProxoolServlet.class, "destroy() - close data source error", e);
			} 
		}
		ProxoolFacade.shutdown();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
