package com.parttime.dao;

import java.util.List;

import com.parttime.model.Address;
import com.parttime.model.Employee;
import com.parttime.model.OrderAndRecruitment;
import com.parttime.model.Orders;
import com.parttime.util.JdbcUtil;

public class EmployeeDao {
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

	// 通过雇员id查找订单信息
	public List<OrderAndRecruitment> queryOrders(Employee emp) throws Exception {
		sql = "SELECT	orders_id,	orders.employee_id,	orders.employee_name,	employee_sex,	"
				+ "employee_education,	employee_tell,	employee_resume,"
				+ "orders.business_id,	orders.business_name,	orders.recruitment_id,	"
				+ "orders.recruitment_name,	orders_state,	employee_evaluated,	business_evaluated,"
				+ "	orders_time ,recruitment_area,recruitment_salary,recruitment_num,recruitment_time,"
				+ "recruitment_duration,recruitment_welfare,recruitment_jobcontent,"
				+ "recruitment_jobrequirements,recruitment_label	FROM	orders ,"
				+ "recruitment WHERE	 orders.recruitment_id =  recruitment.recruitment_id "
				+ " and orders.employee_id = ?";
		List<OrderAndRecruitment> orders_list = jdbc.queryPreparedStatement(sql, OrderAndRecruitment.class, emp.getEmployee_id());
		return orders_list;
	}
}
