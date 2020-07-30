package com.parttime.dao;

import java.util.List;

import com.parttime.model.Address;
import com.parttime.model.Arbitration;
import com.parttime.model.BusinessEvaluation;
import com.parttime.model.Employee;
import com.parttime.model.Orders;
import com.parttime.model.Recruitment;
import com.parttime.util.JdbcUtil;

public class EmployeeDao_LIU {
	JdbcUtil jdbc = new JdbcUtil();
	String sql = "";

	// 将雇员完善信息插入表中
	public void insertEmployeeInfo(Employee emp) throws Exception {
		sql = "update employee set `employee_age`= ?,employee_account = ?,employee_label = ? where employee_email = ?";
		jdbc.updatePreparedStatement(sql, emp.getEmployee_age(), emp.getEmployee_account(), emp.getEmployee_label(),
				emp.getEmployee_email());
	}

	// 将雇员地址id插入表中
	public void insertEmployeeID(Employee emp) throws Exception {
		sql = "update employee set `address_id`= ? where employee_email = ?";
		jdbc.updatePreparedStatement(sql, emp.getAddress_id(), emp.getEmployee_email());
	}

	// 通过邮箱账号查询雇员信息
	public List<Employee> queryEmployeeInfo(Employee emp) throws Exception {
		sql = "SELECT employee_id,employee_name,employee_age,employee_sex,"
				+ "employee_tell,employee_email,employee_password,employee_account,"
				+ "employee_school,employee_label,address_id from employee where employee_email = ? ";
		List<Employee> employee_list = jdbc.queryPreparedStatement(sql, Employee.class, emp.getEmployee_email());
		return employee_list;
	}

	// 修改雇员电话
	public void updateEmployeeTell(Employee emp) throws Exception {
		sql = "update employee set employee_tell = ? where employee_email = ?";
		jdbc.updatePreparedStatement(sql, emp.getEmployee_tell(), emp.getEmployee_email());
	}

	// 修改雇员邮箱
	public void updateEmployeeEmail(Employee emp) throws Exception {
		sql = "update employee set employee_email = ? where employee_tell = ?";
		jdbc.updatePreparedStatement(sql, emp.getEmployee_email(), emp.getEmployee_tell());
	}

	// 修改雇员工作方向标签
	public void updateEmployeeLabel(Employee emp) throws Exception {
		sql = "update employee set employee_label = ? where employee_email = ?";
		jdbc.updatePreparedStatement(sql, emp.getEmployee_label(), emp.getEmployee_email());
	}

	// 修改雇员密码
	public void alterEmployeePassword(Employee emp) throws Exception {
		sql = "update employee set employee_password = ? where employee_email = ?";
		jdbc.updatePreparedStatement(sql, emp.getEmployee_password(), emp.getEmployee_email());
	}

	// 将地址插入到库中
	public void insertAddress(Address add) throws Exception {
		sql = "INSERT into address VALUES(NULL,?,?,?,?,?,NULL)";
		jdbc.updatePreparedStatement(sql, add.getAddress_province(), add.getAddress_city(), add.getAddress_county(),
				add.getAddress_detail(), add.getEmployee_id());
	}

	// 通过雇员编号查询地址信息
	public List<Address> queryAddress(Address add) throws Exception {
		sql = "SELECT address_id,address_province,address_city,address_county,"
				+ "address_detail,employee_id,business_id from address where employee_id = ?";
		List<Address> address_list = jdbc.queryPreparedStatement(sql, Address.class, add.getEmployee_id());
		return address_list;
	}

	// 通过employee_id查询订单
	public List<Orders> queryOrder(Employee emp) throws Exception {
		sql = "SELECT orders.orders_id,orders.employee_id,orders.employee_name,orders.employee_sex,orders.employee_education,orders.employee_tell,orders.employee_resume,orders.business_id,orders.business_name,orders.recruitment_id,orders.recruitment_name,orders.orders_state,orders.employee_evaluated,orders.business_evaluated,orders.orders_time from orders where orders.employee_id = ?";
		List<Orders> orders = jdbc.queryPreparedStatement(sql, Orders.class, emp.getEmployee_id());
		return orders;
	}

	// 通过recruitment_id查询工作
	public List<Recruitment> queryRecruitment(Orders order) throws Exception {
		sql = "SELECT recruitment.recruitment_id,recruitment.recruitment_name,recruitment.recruitment_area,recruitment.recruitment_salary,recruitment.recruitment_num,recruitment.recruitment_time,recruitment.recruitment_duration,recruitment.recruitment_welfare,recruitment.recruitment_jobcontent,recruitment.recruitment_jobrequirements,recruitment.recruitment_label,recruitment.business_id,recruitment.business_name from recruitment WHERE  recruitment.recruitment_id = ?";
		List<Recruitment> recruitments = jdbc.queryPreparedStatement(sql, Recruitment.class, order.getRecruitment_id());
		return recruitments;
	}
	// 通过recruitment_id查询工作
	public List<Recruitment> queryRecruitment(String recruitmentid) throws Exception {
		sql = "SELECT recruitment.recruitment_id,recruitment.recruitment_name,recruitment.recruitment_area,recruitment.recruitment_salary,recruitment.recruitment_num,recruitment.recruitment_time,recruitment.recruitment_duration,recruitment.recruitment_welfare,recruitment.recruitment_jobcontent,recruitment.recruitment_jobrequirements,recruitment.recruitment_label,recruitment.business_id,recruitment.business_name from recruitment WHERE  recruitment.recruitment_id = ?";
		List<Recruitment> recruitments = jdbc.queryPreparedStatement(sql, Recruitment.class, recruitmentid);
		return recruitments;
	}

	// 插入仲裁信息
	public void insertArbitration(Arbitration arbitration) throws Exception {
		sql = "INSERT into arbitration VALUES(NULL,?,?,?,'受理中')";
		jdbc.updatePreparedStatement(sql, arbitration.getOrders_id(), arbitration.getEmployee_id(),
				arbitration.getArbitration_content());
	}

	// 取消订单
	public void beseitigenOrder(Orders orders) throws Exception {
		sql = "delete from orders where orders_id = ?";
		jdbc.updatePreparedStatement(sql, orders.getOrders_id());
	}

	// 通过employee_id查询已评价订单
	public List<Orders> queryOrder2(Employee emp) throws Exception {
		sql = "SELECT orders.orders_id,orders.employee_id,orders.employee_name,orders.employee_sex,orders.employee_education,orders.employee_tell,orders.employee_resume,orders.business_id,orders.business_name,orders.recruitment_id,orders.recruitment_name,orders.orders_state,orders.employee_evaluated,orders.business_evaluated,orders.orders_time from orders where orders.business_evaluated = 'YES' and orders.employee_id = ?";
		List<Orders> orders = jdbc.queryPreparedStatement(sql, Orders.class, emp.getEmployee_id());
		return orders;
	}

	// 通过Orders_id查询雇员对商家的评价
	public List<BusinessEvaluation> queryEvaluation(Orders order) throws Exception {
		sql = "SELECT business_evaluation.business_evaluation_id,business_evaluation.business_evaluation_rate,business_evaluation.business_evaluation_context,business_evaluation.business_evaluation_time,business_evaluation.business_id,business_evaluation.orders_id FROM business_evaluation WHERE business_evaluation.orders_id = ?";
		List<BusinessEvaluation> businessEvaluations = jdbc.queryPreparedStatement(sql, BusinessEvaluation.class,
				order.getOrders_id());
		return businessEvaluations;
	}

	// 删除评价
	public void deleteEvaluation(BusinessEvaluation eEvaluation) throws Exception {
		sql = "delete from business_evaluation where business_evaluation_id = ?";
		jdbc.updatePreparedStatement(sql, eEvaluation.getBusiness_evaluation_id());
	}

	// 修改订单评价状态
	public void updateEvaluation(BusinessEvaluation eEvaluation) throws Exception {
		sql = "update orders set business_evaluated = 'NO' where orders_id = ?";
		jdbc.updatePreparedStatement(sql, eEvaluation.getOrders_id());
	}

	// 通过Orders_id查询雇员对商家的评价
	public List<Arbitration> queryArbitration(Orders order) throws Exception {
		sql = "SELECT arbitration.arbitration_id,arbitration.orders_id,arbitration.employee_id,arbitration.arbitration_content,arbitration.arbitration_state FROM arbitration where arbitration.orders_id = ?";
		List<Arbitration> arbitrations = jdbc.queryPreparedStatement(sql, Arbitration.class, order.getOrders_id());
		return arbitrations;
	}

	// 取消仲裁
	public void deleteArbitration(Arbitration arbitration) throws Exception {
		sql = "delete from arbitration where arbitration_id = ?";
		jdbc.updatePreparedStatement(sql, arbitration.getArbitration_id());
	}

	// 取消仲裁 通过order_id取消
	public void deleteArbitration(Orders orders) throws Exception {
		sql = "delete from arbitration where orders_id = ?";
		jdbc.updatePreparedStatement(sql, orders.getOrders_id());
	}

}
