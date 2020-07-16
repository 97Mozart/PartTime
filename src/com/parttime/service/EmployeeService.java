package com.parttime.service;

import java.util.List;

import com.parttime.dao.EmployeeDao;
import com.parttime.model.Address;
import com.parttime.model.Employee;

public class EmployeeService {
	EmployeeDao dao = new EmployeeDao();

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
}
