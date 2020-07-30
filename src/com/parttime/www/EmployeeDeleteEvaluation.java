package com.parttime.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.BusinessEvaluation;
import com.parttime.model.Employee;
import com.parttime.service.EmployeeService;
import com.parttime.util.Conversion;

/**
 * 雇员删除评价
 * 
 * @author 刘展望
 *
 */
public class EmployeeDeleteEvaluation extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		
		try {
			BusinessEvaluation eEvaluation = new BusinessEvaluation();// 雇员评价表对象
			Conversion.convert(eEvaluation, request);

			// 通过评价表编号删除评价
			service.deleteEvaluation(eEvaluation);
			service.updateEvaluation(eEvaluation);
			request.setAttribute("mess", "评价已删除");
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
