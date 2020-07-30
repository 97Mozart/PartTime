package com.parttime.model;

public class Employee {
	private int employee_id;
	private String employee_name;
	private int employee_age;
	private String employee_sex;
	private String employee_tell;
	private String employee_email;
	private String employee_password;
	private String employee_account;
	private String employee_school;
	private String employee_label;
	private Integer address_id;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public int getEmployee_age() {
		return employee_age;
	}
	public void setEmployee_age(int employee_age) {
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
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	
	public Employee(int employee_id, String employee_name, int employee_age, String employee_sex, String employee_tell,
			String employee_email, String employee_password, String employee_account, String employee_school,
			String employee_label, int address_id) {
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_age = employee_age;
		this.employee_sex = employee_sex;
		this.employee_tell = employee_tell;
		this.employee_email = employee_email;
		this.employee_password = employee_password;
		this.employee_account = employee_account;
		this.employee_school = employee_school;
		this.employee_label = employee_label;
		this.address_id = address_id;
	}
	public Employee() {
	}
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_age="
				+ employee_age + ", employee_sex=" + employee_sex + ", employee_tell=" + employee_tell
				+ ", employee_email=" + employee_email + ", employee_password=" + employee_password
				+ ", employee_account=" + employee_account + ", employee_school=" + employee_school
				+ ", employee_label=" + employee_label + ", address_id=" + address_id + "]";
	}
	
}
