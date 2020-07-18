package com.parttime.model;

//仲裁表
public class Arbitration {
	private Integer arbitration_id;// 仲裁编号
	private Integer orders_id;// 订单编号
	private Integer employee_id;// 雇员编号
	private String arbitration_content;// 仲裁内容
	private String arbitration_state;// 仲裁状态

	public Integer getArbitration_id() {
		return arbitration_id;
	}

	public void setArbitration_id(Integer arbitration_id) {
		this.arbitration_id = arbitration_id;
	}

	public Integer getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(Integer orders_id) {
		this.orders_id = orders_id;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getArbitration_content() {
		return arbitration_content;
	}

	public void setArbitration_content(String arbitration_content) {
		this.arbitration_content = arbitration_content;
	}

	public String getArbitration_state() {
		return arbitration_state;
	}

	public void setArbitration_state(String arbitration_state) {
		this.arbitration_state = arbitration_state;
	}

}
