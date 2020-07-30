package com.parttime.service;

/**
 * 雇员信息处理
 */
import java.util.List;

import com.parttime.dao.EmployeeDao_LIU;
import com.parttime.model.Address;
import com.parttime.model.Arbitration;
import com.parttime.model.BusinessEvaluation;
import com.parttime.model.Employee;
import com.parttime.model.Orders;
import com.parttime.model.Recruitment;

public class EmployeeService {
	EmployeeDao_LIU dao = new EmployeeDao_LIU();

	// 将雇员完善信息插入表中
	public void insertEmployeeInfo(Employee emp) throws Exception {
		dao.insertEmployeeInfo(emp);
	}

	// 将雇员地址id插入表中
	public void insertEmployeeID(Employee emp) throws Exception {
		dao.insertEmployeeID(emp);
	}

	// 通过邮箱账号查询雇员信息
	public List<Employee> queryEmployeeInfo(Employee emp) throws Exception {
		return dao.queryEmployeeInfo(emp);
	}

	// 修改雇员电话
	public void updateEmployeeTell(Employee emp) throws Exception {
		dao.updateEmployeeTell(emp);
	}

	// 修改雇员邮箱
	public void updateEmployeeEmail(Employee emp) throws Exception {
		dao.updateEmployeeEmail(emp);
	}

	// 修改雇员工作方向标签
	public void updateEmployeeLabel(Employee emp) throws Exception {
		dao.updateEmployeeLabel(emp);
	}

	// 修改雇员工作方向标签
	public void alterEmployeePassword(Employee emp) throws Exception {
		dao.alterEmployeePassword(emp);
	}

	// 将地址插入到库中
	public void insertAddress(Address add) throws Exception {
		dao.insertAddress(add);
	}

	// 通过雇员编号查询地址信息
	public List<Address> queryAddress(Address add) throws Exception {
		return dao.queryAddress(add);
	}

	// 通过employee_id查询订单
	public List<Orders> queryOrder(Employee emp) throws Exception {
		return dao.queryOrder(emp);
	}

	// 通过recruitment_id查询工作
	public List<Recruitment> queryRecruitment(Orders order) throws Exception {
		return dao.queryRecruitment(order);
	}
	// 通过recruitment_id查询工作
	public List<Recruitment> queryRecruitment(String recruitmentid) throws Exception {
		return dao.queryRecruitment(recruitmentid);
	}

	// 插入仲裁信息
	public void insertArbitration(Arbitration arbitration) throws Exception {
		dao.insertArbitration(arbitration);
	}

	// 取消订单
	public void beseitigenOrder(Orders orders) throws Exception {
		dao.beseitigenOrder(orders);
	}

	// 通过employee_id查询已评价订单
	public List<Orders> queryOrder2(Employee emp) throws Exception {
		return dao.queryOrder2(emp);
	}

	// 通过recruitment_id查询雇员对商家的评价
	public List<BusinessEvaluation> queryEvaluation(Orders order) throws Exception {
		return dao.queryEvaluation(order);
	}

	// 删除评价
	public void deleteEvaluation(BusinessEvaluation eEvaluation) throws Exception {
		dao.deleteEvaluation(eEvaluation);
	}

	// 修改订单评价状态
	public void updateEvaluation(BusinessEvaluation eEvaluation) throws Exception {
		dao.updateEvaluation(eEvaluation);
	}

	// 通过Orders_id查询雇员对商家的评价
	public List<Arbitration> queryArbitration(Orders order) throws Exception {
		return dao.queryArbitration(order);
	}

	// 取消仲裁
	public void deleteArbitration(Arbitration arbitration) throws Exception {
		dao.deleteArbitration(arbitration);
	}

	// 取消仲裁 通过order_id取消
	public void deleteArbitration(Orders orders) throws Exception {
		dao.deleteArbitration(orders);
	}
}
