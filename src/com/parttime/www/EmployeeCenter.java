package com.parttime.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.Employee;

/**
 * 处理session信息跳转到个人中心 【此页面需要修缮】
 * 
 * @author 刘展望
 *
 */
public class EmployeeCenter extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");

		// 判断是否为新注册用户 如果默认Address_id为int类型删除employee.getAddress_id()==null
		if (employee.getAddress_id() == null || employee.getAddress_id().equals("") || employee.getAddress_id() == 0) {
			request.getRequestDispatcher("user-info-add.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("user-center.jsp").forward(request, response);
		}

	}
}
