package com.parttime.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.Employee;
import com.parttime.model.Orders;
import com.parttime.service.EmployeeService;
import com.parttime.util.Conversion;

/**
 * 处理取消订单界面
 * 
 * @author 刘展望
 *
 */
public class EmployeeCancelOrder extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		
		try {
			Orders orders = new Orders();
			Conversion.convert(orders, request);

			// 通过订单编号删除订单	需要先删除仲裁信息
			service.deleteArbitration(orders);
			service.beseitigenOrder(orders);
			request.setAttribute("mess", "订单已删除");
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
		
		doPost(request, response);
		

	}

}
