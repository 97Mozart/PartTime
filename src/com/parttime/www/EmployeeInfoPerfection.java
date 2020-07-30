package com.parttime.www;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.Address;
import com.parttime.model.Employee;
import com.parttime.service.EmployeeService;
import com.parttime.util.Conversion;

/**
 * 处理用户信息完善界面
 * 
 * @author 刘展望
 *
 */
public class EmployeeInfoPerfection extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		EmployeeService service = new EmployeeService();

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

			request.setAttribute("mess", "个人信息已完善");
			request.getRequestDispatcher("user-center.jsp").forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("error", 500);
			response.sendRedirect("error.jsp");
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 判断用户是否登录
		HttpSession session = request.getSession();
		Employee emp = (Employee) session.getAttribute("employee");
		if (emp == null || emp.equals("")) {
			
			response.sendRedirect("login");
			return;
		}
		
	}

}
