package com.parttime.www;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.Arbitration;
import com.parttime.model.Employee;
import com.parttime.model.Orders;
import com.parttime.service.EmployeeService;

/**
 * 我的仲裁页面
 * 
 * @author 刘展望
 *
 */
public class EmployeeArbitration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		
		try {
			// 查询session中 账户信息
			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");

			List<Orders> orders = service.queryOrder(employee);//查询订单
			Map<Orders,Arbitration> arbitrations = new HashMap<Orders,Arbitration>();
			for (Orders order : orders) {
				List<Arbitration> temp = service.queryArbitration(order);
				Arbitration arbitration = null;
				if (temp != null && temp.size() > 0) {
					arbitration = temp.get(0);
					arbitrations.put(order, arbitration);
				}
			}
			request.setAttribute("arbitrations", arbitrations);
			
			
			/*// 通过雇员id查找仲裁信息
			List<OrdersAndArbitration> arbitration_list = service.queryArbitration(employee);
			request.setAttribute("arbitration_list", arbitration_list);*/

			request.getRequestDispatcher("arbitration.jsp").forward(request, response);
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
