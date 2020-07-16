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
@WebServlet("/user")
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
		} else if (action.equals("exit")) {
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
		} else if (action.equals("update")) {

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
			jdbc.close();

			// 登录成功
			if (employees.size() > 0) {
				Employee employee = employees.get(0);
				// 将用户名存入session对象
				HttpSession session = request.getSession();
				// 将用户对象存入session中
				session.setAttribute("employee", employee);
				
				Integer address_id = employee.getAddress_id();
				//判断是否为新注册用户
				if(employee.getAddress_id()==null || employee.getAddress_id().equals("") || employee.getAddress_id()==0){
					request.getRequestDispatcher("user-info-add.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("user-center.jsp").forward(request, response);
				}
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
