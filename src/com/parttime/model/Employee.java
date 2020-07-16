package com.parttime.model;

/*
 * 对应雇员信息表	employee
 */
public class Employee {
	private Integer employee_id;// 用户真实姓名 为空自动升序
	private String employee_name;// 用户真实姓名
	private Integer employee_age;// 用户年龄 可为空
	private String employee_sex;// 用户性别
	private String employee_tell;// 用户电话
	private String employee_email;// 用户邮箱
	private String employee_password;// 用户密码
	private String employee_account;// 用户账号 可为空
	private String employee_school;// 用户学校
	private String employee_label;// 用户工作方向标签 可为空
	private Integer address_id;// 用户地址编号 可为空

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public Integer getEmployee_age() {
		return employee_age;
	}

	public void setEmployee_age(Integer employee_age) {
		this.employee_age = employee_age;
	}

	public String getEmployee_sex() {
		return employee_sex;
	}

	public void setEmployee_sex(String employee_sex) {
		this.employee_sex = employee_sex;
	}

	public String getEmployee_tell() {
		return employee_tell;
	}

	public void setEmployee_tell(String employee_tell) {
		this.employee_tell = employee_tell;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public String getEmployee_password() {
		return employee_password;
	}

	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}

	public String getEmployee_account() {
		return employee_account;
	}

	public void setEmployee_account(String employee_account) {
		this.employee_account = employee_account;
	}

	public String getEmployee_school() {
		return employee_school;
	}

	public void setEmployee_school(String employee_school) {
		this.employee_school = employee_school;
	}

	public String getEmployee_label() {
		return employee_label;
	}

	public void setEmployee_label(String employee_label) {
		this.employee_label = employee_label;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

}
