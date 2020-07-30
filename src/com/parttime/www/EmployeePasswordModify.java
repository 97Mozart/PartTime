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
 * 用户修改密码
 * 
 * @author 刘展望
 *
 */
public class EmployeePasswordModify extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		
		try {
			// 查询密码
			String password = request.getParameter("employee_password");
			String password1 = request.getParameter("employee_password_new1");
			String password2 = request.getParameter("employee_password_new2");

			// 查询session中 账户信息
			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");

			if (password1.equals(password2)) {
				if (password.equals(employee.getEmployee_password())) {
					// 将新密码赋给雇员对象
					employee.setEmployee_password(password1);

					service.alterEmployeePassword(employee);

					session.removeAttribute("employee");
					session.setAttribute("employee", employee);
					request.setAttribute("mess", "密码修改成功");
					request.getRequestDispatcher("user-center.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("mess", "请检查两次输入是否一致");
				request.getRequestDispatcher("EmployeePasswordModify").forward(request, response);
				response.sendRedirect("EmployeePasswordModify");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "请输入正确密码");
			request.getRequestDispatcher("EmployeePasswordModify").forward(request, response);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 判断用户是否登录
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");

		if (employee == null || employee.equals("")) {
			response.sendRedirect("login");
			return;
		}

		request.getRequestDispatcher("user-password.jsp").forward(request, response);

	}

}
