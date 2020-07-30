package com.parttime.model;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2020-07-13 16:07:00
 */
@SuppressWarnings(value = "all")
public class Orders {

    private Integer orders_id;
    /**
    * 从session获得，页面中不显示
    */
    private Integer employee_id;
    /**
    * 从session获得，页面中不能修改
    */
    private String employee_name;
    /**
    * 从session获得，页面中不能修改
    */
    private String employee_sex;
    /**
    * 学历
    */
    private String employee_education;
    /**
    * 从session获得，页面中不能修改
    */
    private String employee_tell;
    /**
    * 自我描述，推荐
    */
    private String employee_resume;
    /**
    * 根据order_id查询获得
    */
    private Integer business_id;
    
    private String business_name;
    
    private Integer recruitment_id;
    
    private String recruitment_name;
    
    private String orders_state;
    /**
    * 标记是否已评价
    */
    private String employee_evaluated;
    
    private String business_evaluated;
    /**
    * 下单时间
    */
    private String orders_time;


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

    public String getOrders_time() {
        return orders_time;
    }

    public void setOrders_time(String orders_time) {
        this.orders_time = orders_time;
    }

    public Orders() {
    }

    public Orders(Integer orders_id, Integer employee_id, String employee_name, String employee_sex, String employee_education, String employee_tell, String employee_resume, Integer business_id, String business_name, Integer recruitment_id, String recruitment_name, String orders_state, String employee_evaluated, String business_evaluated, String orders_time) {
        this.orders_id = orders_id;
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_sex = employee_sex;
        this.employee_education = employee_education;
        this.employee_tell = employee_tell;
        this.employee_resume = employee_resume;
        this.business_id = business_id;
        this.business_name = business_name;
        this.recruitment_id = recruitment_id;
        this.recruitment_name = recruitment_name;
        this.orders_state = orders_state;
        this.employee_evaluated = employee_evaluated;
        this.business_evaluated = business_evaluated;
        this.orders_time = orders_time;
    }

	@Override
	public String toString() {
		return "Orders [orders_id=" + orders_id + ", employee_id=" + employee_id + ", employee_name=" + employee_name
				+ ", employee_sex=" + employee_sex + ", employee_education=" + employee_education + ", employee_tell="
				+ employee_tell + ", employee_resume=" + employee_resume + ", business_id=" + business_id
				+ ", business_name=" + business_name + ", recruitment_id=" + recruitment_id + ", recruitment_name="
				+ recruitment_name + ", orders_state=" + orders_state + ", employee_evaluated=" + employee_evaluated
				+ ", business_evaluated=" + business_evaluated + ", orders_time=" + orders_time + "]";
	}
    
}