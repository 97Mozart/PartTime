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

import com.parttime.model.BusinessEvaluation;
import com.parttime.model.Employee;
import com.parttime.model.Orders;
import com.parttime.service.EmployeeService;

/**
 * 订单评价界面
 * 
 * @author 刘展望
 *
 */
public class EmployeeEvaluate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		
		try {
			// 查询session中 账户信息
			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");

			List<Orders> orders = service.queryOrder2(employee);//查询 已评价订单
			Map<Orders,BusinessEvaluation> businessEvaluations = new HashMap<Orders,BusinessEvaluation>();
			for (Orders order : orders) {
				BusinessEvaluation businessEvaluation = service.queryEvaluation(order).get(0);
				businessEvaluations.put(order, businessEvaluation);
			}
			request.setAttribute("businessEvaluations", businessEvaluations);
			
			request.getRequestDispatcher("evaluation.jsp").forward(request, response);
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
