package com.parttime.model;

/*
 * 管理员表
 */

public class Admin {
	private Integer admin_id;// 管理员编号
	private String admin_name;// 管理员账号
	private String admin_password;// 管理员密码

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

}
