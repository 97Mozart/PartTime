package com.parttime.www;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.Employee;
import com.parttime.service.EmployeeService;

/**
 * 用户退出
 * 
 * @author 刘展望
 *
 */
public class EmployeeExist extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 查询session中 账户信息
		HttpSession session = request.getSession();
		session.invalidate();// 销毁session对象
		// 跳转回登录页面
		response.sendRedirect("login");

	}

}
