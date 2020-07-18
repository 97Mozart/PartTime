package com.parttime.model;

import java.util.Date;

/*
 * 订单表以及雇员评价表	orders
 */

public class OrdersAndEvaluation {
	private Integer orders_id;// 订单编号 自增
	private Integer employee_id;// 雇员编号
	private String employee_name;// 雇员姓名
	private String employee_sex;// 雇员性别
	private String employee_education;// 雇员学历
	private String employee_tell;// 雇员电话
	private String employee_resume;// 雇员自我描述
	private Integer business_id;// 商家编号
	private String business_name;// 商家名称
	private Integer recruitment_id;// 工作编号
	private String recruitment_name;// 工作名称
	private String orders_state;// 订单状态
	private String employee_evaluated;// 雇员对商家的评价标记 YES NO
	private String business_evaluated;// 商家对雇员的评价标记 YES NO
	private Date orders_time;// 订单时间

	private Integer business_evaluation_id;// 评价表编号 自增
	private String business_evaluation_rate;// 评价等级
	private String business_evaluation_context;// 评价内容
	private Date business_evaluation_time;// 评价时间

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

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_sex() {
		return employee_sex;
	}

	public void setEmployee_sex(String employee_sex) {
		this.employee_sex = employee_sex;
	}

	public String getEmployee_education() {
		return employee_education;
	}

	public void setEmployee_education(String employee_education) {
		this.employee_education = employee_education;
	}

	public String getEmployee_tell() {
		return employee_tell;
	}

	public void setEmployee_tell(String employee_tell) {
		this.employee_tell = employee_tell;
	}

	public String getEmployee_resume() {
		return employee_resume;
	}

	public void setEmployee_resume(String employee_resume) {
		this.employee_resume = employee_resume;
	}

	public Integer getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(Integer business_id) {
		this.business_id = business_id;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public Integer getRecruitment_id() {
		return recruitment_id;
	}

	public void setRecruitment_id(Integer recruitment_id) {
		this.recruitment_id = recruitment_id;
	}

	public String getRecruitment_name() {
		return recruitment_name;
	}

	public void setRecruitment_name(String recruitment_name) {
		this.recruitment_name = recruitment_name;
	}

	public String getOrders_state() {
		return orders_state;
	}

	public void setOrders_state(String orders_state) {
		this.orders_state = orders_state;
	}

	public String getEmployee_evaluated() {
		return employee_evaluated;
	}

	public void setEmployee_evaluated(String employee_evaluated) {
		this.employee_evaluated = employee_evaluated;
	}

	public String getBusiness_evaluated() {
		return business_evaluated;
	}

	public void setBusiness_evaluated(String business_evaluated) {
		this.business_evaluated = business_evaluated;
	}

	public Date getOrders_time() {
		return orders_time;
	}

	public void setOrders_time(Date orders_time) {
		this.orders_time = orders_time;
	}

	public Integer getBusiness_evaluation_id() {
		return business_evaluation_id;
	}

	public void setBusiness_evaluation_id(Integer business_evaluation_id) {
		this.business_evaluation_id = business_evaluation_id;
	}

	public String getBusiness_evaluation_rate() {
		return business_evaluation_rate;
	}

	public void setBusiness_evaluation_rate(String business_evaluation_rate) {
		this.business_evaluation_rate = business_evaluation_rate;
	}

	public String getBusiness_evaluation_context() {
		return business_evaluation_context;
	}

	public void setBusiness_evaluation_context(String business_evaluation_context) {
		this.business_evaluation_context = business_evaluation_context;
	}

	public Date getBusiness_evaluation_time() {
		return business_evaluation_time;
	}

	public void setBusiness_evaluation_time(Date business_evaluation_time) {
		this.business_evaluation_time = business_evaluation_time;
	}

}
