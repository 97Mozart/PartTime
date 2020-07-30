package com.parttime.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.Employee;
import com.parttime.model.Recruitment;
import com.parttime.service.EmployeeService;

/**
 * 工作详情界面
 * 
 * @author 刘展望
 *
 */
public class EmployeeOrderInfo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService service = new EmployeeService();

		try {
			String recruitment_id = request.getParameter("recruitmentid");
			Recruitment recruitment = service.queryRecruitment(recruitment_id).get(0);
			request.setAttribute("recruitment", recruitment);
			request.getRequestDispatcher("order-info.jsp").forward(request, response);
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
