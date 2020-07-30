package com.parttime.www;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.Admin;
import com.parttime.model.Employee;
import com.parttime.util.JdbcUtil;

/*
 * 临时登录页面处理
 */
/**
 * Servlet implementation class LoginServlet
 */
public class UserServlet extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		if (action.equals("login")) {
			login(request, response);
			return;
		}

	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");// 获取到登录页面的用户名
		String password = request.getParameter("password");// 获取到登录页面的密码

		JdbcUtil jdbc = new JdbcUtil();
		String sql = "select * from employee where employee_email=? and employee_password = ?";
		try {
			List<Employee> employees = jdbc.queryPreparedStatement(sql, Employee.class, username, password);
			// 登录成功
			if (employees.size() > 0) {
				Employee employee = employees.get(0);
				// 将用户名存入session对象
				HttpSession session = request.getSession();
				// 将用户对象存入session中
				session.setAttribute("employee", employee);
				
				response.sendRedirect("EmployeeCenter");
			} else {
				// 登录失败
				request.setAttribute("mess", "账号或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
