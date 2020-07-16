package com.parttime.www;

/**
 * 处理修改雇员信息
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.Address;
import com.parttime.model.Employee;
import com.parttime.service.EmployeeService;
import com.parttime.util.Conversion;

/**
 * Servlet implementation class EmployeeInfoServlet
 */
@WebServlet("/EmployeeInfoServlet")
public class EmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeService service = new EmployeeService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeInfoServlet() {
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

		// 判断用户是否登录

		// 返回操作
		String action = request.getParameter("action");
		if (action.equals("insertEmployeeInfo")) {
			insertEmployeeInfo(request, response);
		} else if (action.equals("queryEmployeeInfo")) {
			queryEmployeeInfo(request, response);
		} else if (action.equals("updateEmployeeTell")) {
			updateEmployeeTell(request, response);
		} else if (action.equals("updateEmployeeEmail")) {
			updateEmployeeEmail(request, response);
		} else if (action.equals("updateEmployeeLabel")) {
			updateEmployeeLabel(request, response);
		} else if (action.equals("alterEmployeePassword")) {
			alterEmployeePassword(request, response);
		} else if (action.equals("topassword")) {
			topassword(request, response);
		} else if (action.equals("exit")) {
			exit(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 将雇员完善信息插入库中
	protected void insertEmployeeInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 给雇员对象赋值
		Employee employee = new Employee();
		Conversion.convert(employee, request);

		// 通过邮箱号码赋值
		HttpSession session = request.getSession();
		Employee emp = (Employee) session.getAttribute("employee");
		employee.setEmployee_email(emp.getEmployee_email());// 将邮箱账号赋给employee对象

		try {
			service.insertEmployeeInfo(employee);

			// 插入成功后查询雇员信息
			List<Employee> employee_list = service.queryEmployeeInfo(employee);

			Address address = new Address();
			Conversion.convert(address, request);
			address.setEmployee_id(employee_list.get(0).getEmployee_id());// 将雇员编号赋给address对象

			// 将地址信息插入到库中
			service.insertAddress(address);

			// 重新查询地址信息
			List<Address> address_list = service.queryAddress(address);

			// 将地址编号重新插入到雇员表中
			employee.setAddress_id(address_list.get(0).getAddress_id());// 将地址id赋给employee对象
			service.insertEmployeeID(employee);

			response.sendRedirect("user-center.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	// 查询雇员信息，并跳到个人资料页面
	protected void queryEmployeeInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查询session中 账户信息
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");

		try {
			List<Employee> employee_list = service.queryEmployeeInfo(employee);
			// 将雇员信息传入request中
			request.setAttribute("employee", employee_list.get(0));
			request.getRequestDispatcher("user-info.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	// 修改手机号
	protected void updateEmployeeTell(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tell = request.getParameter("employee_tell");
		// 查询session中 账户信息
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		employee.setEmployee_tell(tell);// 将新设置的手机号传给雇员对象

		// 更改库中信息
		try {
			service.updateEmployeeTell(employee);
			// 重新查询信息并跳转会个人资料页面
			queryEmployeeInfo(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	// 修改邮箱
	protected void updateEmployeeEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			queryEmployeeInfo(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	// 修改雇员工作方向标签
	protected void updateEmployeeLabel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String label = request.getParameter("employee_label");
		// 查询session中 账户信息
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		employee.setEmployee_label(label);// 将新设置的工作方向传给雇员对象

		// 更改库中信息
		try {
			service.updateEmployeeLabel(employee);
			// 重新查询信息并跳转会个人资料页面
			queryEmployeeInfo(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	// 修改雇员密码
	protected void alterEmployeePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
					topassword(request, response);
				}
			} else {
				request.setAttribute("mess", "密码修改失败");
				topassword(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mess", "密码修改失败");
			topassword(request, response);
		}

	}

	// 跳转到修改密码页面
	protected void topassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("user-password.jsp").forward(request, response);
	}

	// 退出系统
	protected void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 查询session中 账户信息
		HttpSession session = request.getSession();
		session.invalidate();// 销毁session对象
		// 跳转回登录页面
		response.sendRedirect("login.jsp");
	}

}
