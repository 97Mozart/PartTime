package com.parttime.www;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parttime.model.Arbitration;
import com.parttime.model.EEvaluation;
import com.parttime.model.Employee;
import com.parttime.model.OrderAndRecruitment;
import com.parttime.model.Orders;
import com.parttime.model.OrdersAndEvaluation;
import com.parttime.service.EmployeeService;
import com.parttime.util.Conversion;

/**
 * 处理订单信息
 */
@WebServlet("/EmployeeOrdersServlet")
public class EmployeeOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeService service = new EmployeeService();

	public EmployeeOrdersServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 判断用户是否登录

		// 返回操作
		String action = request.getParameter("action");
		if (action.equals("toorder")) {
			toorder(request, response);
		} else if (action.equals("insertArbitration")) {
			insertArbitration(request, response);
		} else if (action.equals("toBewerten")) {
			// 跳转评价页面
		} else if (action.equals("toArbitration")) {
			toArbitration(request, response);
		} else if (action.equals("tomywork")) {
			tomywork(request, response);
		} else if (action.equals("beseitigenOrder")) {
			beseitigenOrder(request, response);
		} else if (action.equals("toEvaluation")) {
			toEvaluation(request, response);
		} else if (action.equals("deleteEvaluation")) {
			deleteEvaluation(request, response);
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

	// 跳转到我的订单页面
	protected void toorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 查询session中 账户信息
			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");

			// 通过雇员id查找订单信息
			List<OrderAndRecruitment> orders_list = service.queryOrders(employee);
			request.setAttribute("orders_list", orders_list);

			request.getRequestDispatcher("orders.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	// 跳转申请仲裁页面
	protected void toArbitration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 仲裁表对象赋值
		Arbitration arbitration = new Arbitration();
		Conversion.convert(arbitration, request);
		String business_name = request.getParameter("business_name");
		request.setAttribute("business_name", business_name);
		request.setAttribute("arbitration", arbitration);

		request.getRequestDispatcher("request-arbitration.jsp").forward(request, response);
	}

	// 提交仲裁信息，并跳到我的个人中心
	protected void insertArbitration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 仲裁表对象赋值
		Arbitration arbitration = new Arbitration();
		Conversion.convert(arbitration, request);

		try {
			service.insertArbitration(arbitration);
			request.setAttribute("mess", "提交成功");
			request.getRequestDispatcher("user-center.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	// 跳转到我的订单页面
	protected void tomywork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 查询session中 账户信息
			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");

			// 通过雇员id查找订单信息
			List<OrderAndRecruitment> orders_list = service.queryOrders(employee);
			request.setAttribute("orders_list", orders_list);

			request.getRequestDispatcher("myorders.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	// 取消订单
	protected void beseitigenOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Orders orders = new Orders();
			Conversion.convert(orders, request);

			// 通过订单编号删除订单
			service.beseitigenOrder(orders);
			request.setAttribute("mess", "订单已删除");
			request.getRequestDispatcher("user-center.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	// 跳转到我的评价页面
	protected void toEvaluation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 查询session中 账户信息
			HttpSession session = request.getSession();
			Employee employee = (Employee) session.getAttribute("employee");

			// 通过雇员id查找订单评价信息
			List<OrdersAndEvaluation> evaluation_list = service.queryEvaluation(employee);
			request.setAttribute("evaluation_list", evaluation_list);

			request.getRequestDispatcher("evaluation.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	// 删除评价
	protected void deleteEvaluation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			EEvaluation eEvaluation = new EEvaluation();//雇员评价表对象
			Conversion.convert(eEvaluation, request);

			// 通过评价表编号删除评价
			service.deleteEvaluation(eEvaluation);
			request.setAttribute("mess", "评价已删除");
			request.getRequestDispatcher("user-center.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
}
