package com.parttime.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.Arbitration;
import com.parttime.model.Employee;
import com.parttime.service.EmployeeService;
import com.parttime.util.Conversion;

/**
 * 处理请求仲裁页面
 * 
 * @author 刘展望
 *
 */
public class EmployeeRequestArbitration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		EmployeeService service = new EmployeeService();

		// 仲裁表对象赋值
		Arbitration arbitration = new Arbitration();
		Conversion.convert(arbitration, request);

		try {
			service.insertArbitration(arbitration);
			request.setAttribute("mess", "提交成功");
			request.getRequestDispatcher("user-center.jsp").forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("error", 500);
			e.printStackTrace();
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
		Employee employee = (Employee) session.getAttribute("employee");

		if (employee == null || employee.equals("")) {
			response.sendRedirect("login");
			return;
		}

		// 仲裁表对象赋值
		Arbitration arbitration = new Arbitration();
		Conversion.convert(arbitration, request);
		String business_name = request.getParameter("business_name");
		request.setAttribute("business_name", business_name);
		request.setAttribute("arbitration", arbitration);

		request.getRequestDispatcher("request-arbitration.jsp").forward(request, response);
	}

}
