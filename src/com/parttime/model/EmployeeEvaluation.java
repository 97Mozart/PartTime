package com.parttime.model;

import java.util.Date;

/**
 * @author 咚咚dongdong
 * Date: 2020/7/15
 * Time: 18:34
 */
@SuppressWarnings(value = "all")
public class EmployeeEvaluation {

    /**
     * 商家对雇员的评价
     */
    private Integer employee_evaluation_id;

    /**
     * 评价等级
     */
    private String employee_evaluation_rate;

    /**
     * 评价内容
     */
    private String employee_evaluation_context;

    private Date employee_evaluation_time;

    private Integer employee_id;

    private Integer orders_id;

    public Integer getEmployee_evaluation_id() {
        return employee_evaluation_id;
    }

    public void setEmployee_evaluation_id(Integer employee_evaluation_id) {
        this.employee_evaluation_id = employee_evaluation_id;
    }

    public String getEmployee_evaluation_rate() {
        return employee_evaluation_rate;
    }

    public void setEmployee_evaluation_rate(String employee_evaluation_rate) {
        this.employee_evaluation_rate = employee_evaluation_rate;
    }

    public String getEmployee_evaluation_context() {
        return employee_evaluation_context;
    }

    public void setEmployee_evaluation_context(String employee_evaluation_context) {
        this.employee_evaluation_context = employee_evaluation_context;
    }

    public Date getEmployee_evaluation_time() {
        return employee_evaluation_time;
    }

    public void setEmployee_evaluation_time(Date employee_evaluation_time) {
        this.employee_evaluation_time = employee_evaluation_time;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(Integer orders_id) {
        this.orders_id = orders_id;
    }

    public EmployeeEvaluation() {
    }

    public EmployeeEvaluation(Integer employee_evaluation_id, String employee_evaluation_rate, String employee_evaluation_context, Date employee_evaluation_time, Integer employee_id, Integer orders_id) {
        this.employee_evaluation_id = employee_evaluation_id;
        this.employee_evaluation_rate = employee_evaluation_rate;
        this.employee_evaluation_context = employee_evaluation_context;
        this.employee_evaluation_time = employee_evaluation_time;
        this.employee_id = employee_id;
        this.orders_id = orders_id;
    }

	@Override
	public String toString() {
		return "EmployeeEvaluation [employee_evaluation_id=" + employee_evaluation_id + ", employee_evaluation_rate="
				+ employee_evaluation_rate + ", employee_evaluation_context=" + employee_evaluation_context
				+ ", employee_evaluation_time=" + employee_evaluation_time + ", employee_id=" + employee_id
				+ ", orders_id=" + orders_id + "]";
	}
    
}
