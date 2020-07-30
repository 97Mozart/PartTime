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
 * 用户修改手机，邮箱，标签
 * 
 * @author 刘展望
 *
 */
public class EmployeeInfoModify extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		EmployeeService service = new EmployeeService();
		
		String action = request.getParameter("action");
		if (action.equals("tell")) {
			String tell = request.getParameter("employee_tell");
			// 查询session中 账户信息
			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");
			employee.setEmployee_tell(tell);// 将新设置的手机号传给雇员对象

			// 更改库中信息
			try {
				service.updateEmployeeTell(employee);
				// 重新查询信息并跳转会个人资料页面
				response.sendRedirect("EmployeeInfo");
			} catch (Exception e) {
				request.getSession().setAttribute("error", 500);
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		} else if (action.equals("email")) {
			try {
				String email = request.getParameter("employee_email");

				// 查询session中 账户信息
				HttpSession session = request.getSession();
				Employee employee = (Employee) session.getAttribute("employee");

				List<Employee> employee_list = service.queryEmployeeInfo(employee);// 查询当前账户所有信息
				employee = employee_list.get(0);
				employee.setEmployee_email(email);// 将新设置的邮箱传给雇员对象

				// 更改库中信息
				service.updateEmployeeEmail(employee);
				session.removeAttribute("employee");
				session.setAttribute("employee", employee);
				// 重新查询信息并跳转会个人资料页面
				response.sendRedirect("EmployeeInfo");
			} catch (Exception e) {
				request.getSession().setAttribute("error", 500);
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		} else if (action.equals("label")) {
			String label = request.getParameter("employee_label");
			// 查询session中 账户信息
			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");
			employee.setEmployee_label(label);// 将新设置的工作方向传给雇员对象

			// 更改库中信息
			try {
				service.updateEmployeeLabel(employee);
				// 重新查询信息并跳转会个人资料页面
				response.sendRedirect("EmployeeInfo");
			} catch (Exception e) {
				request.getSession().setAttribute("error", 500);
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
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

		doPost(request, response);

	}

}
