package com.parttime.model;

/*
 * 管理员表
 */
public class Address {
	private Integer address_id;// 地址编号
	private String address_province;// 省份
	private String address_city;// 市区
	private String address_county;// 县城（区）
	private String address_detail;// 详细地址
	private Integer employee_id;// 雇员编号【以下二选一】
	private Integer business_id;// 商家编号

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getAddress_province() {
		return address_province;
	}

	public void setAddress_province(String address_province) {
		this.address_province = address_province;
	}

	public String getAddress_city() {
		return address_city;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	public String getAddress_county() {
		return address_county;
	}

	public void setAddress_county(String address_county) {
		this.address_county = address_county;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public Integer getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(Integer business_id) {
		this.business_id = business_id;
	}

}
