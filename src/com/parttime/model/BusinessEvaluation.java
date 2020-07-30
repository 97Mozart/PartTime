package com.parttime.model;

import java.util.Date;

/**
 * (BusinessEvaluation)实体类
 *
 * @author makejava
 * @since 2020-07-13 14:44:43
 */
@SuppressWarnings(value = "all")
public class BusinessEvaluation {
    /**
     * 雇员对商家的评价
     */
    private Integer business_evaluation_id;
    /**
     * 评价等级
     */
    private String business_evaluation_rate;
    /**
     * 评价内容
     */
    private String business_evaluation_context;

    private Date business_evaluation_time;

    private Integer business_id;

    private Integer orders_id;

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

    public Integer getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    public Integer getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(Integer orders_id) {
        this.orders_id = orders_id;
    }

    public BusinessEvaluation() {
    }

    public BusinessEvaluation(Integer business_evaluation_id, String business_evaluation_rate, String business_evaluation_context, Date business_evaluation_time, Integer business_id, Integer orders_id) {
        this.business_evaluation_id = business_evaluation_id;
        this.business_evaluation_rate = business_evaluation_rate;
        this.business_evaluation_context = business_evaluation_context;
        this.business_evaluation_time = business_evaluation_time;
        this.business_id = business_id;
        this.orders_id = orders_id;
    }

	@Override
	public String toString() {
		return "BusinessEvaluation [business_evaluation_id=" + business_evaluation_id + ", business_evaluation_rate="
				+ business_evaluation_rate + ", business_evaluation_context=" + business_evaluation_context
				+ ", business_evaluation_time=" + business_evaluation_time + ", business_id=" + business_id
				+ ", orders_id=" + orders_id + "]";
	}
    
}