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

import com.parttime.model.Employee;
import com.parttime.model.Orders;
import com.parttime.model.Recruitment;
import com.parttime.service.EmployeeService;

/**
 * 处理我的工作界面	正在进行中的订单
 * 
 * @author 刘展望
 *
 */
public class EmployeeWork extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		
		try {
			// 查询session中 账户信息
			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");

			List<Orders> orders = service.queryOrder(employee);//查询到订单信息
			Map<Orders,Recruitment> recruitments = new HashMap<Orders,Recruitment>();
			for (Orders order : orders) {
				Recruitment recruitment = service.queryRecruitment(order).get(0);
				recruitments.put(order, recruitment);
			}
			request.setAttribute("recruitments", recruitments);
			
			request.getRequestDispatcher("myorders.jsp").forward(request, response);
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
