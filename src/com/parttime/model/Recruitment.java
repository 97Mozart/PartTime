package com.parttime.model;

/**
 * (RecruitmentDetail)实体类
 *
 * @author makejava
 * @since 2020-07-14 09:23:55
 */
@SuppressWarnings(value = "all")
public class Recruitment {

    private Integer recruitment_id;
    /**
     * 工作名字
     */
    private String recruitment_name;
    /**
     * 工作地址
     */
    private String recruitment_area;
    /**
     * 工资
     */
    private Double recruitment_salary;
    /**
     * 需要人数
     */
    private Integer recruitment_num;
    /**
     * 创建时间，插入及更新时，为当前时间，不需要手动赋值
     */
    private String recruitment_time;
    /**
     * 工作时长
     */
    private Integer recruitment_duration;
    /**
     * 福利
     */
    private String recruitment_welfare;
    /**
     * 工作内容
     */
    private String recruitment_jobcontent;
    /**
     * 工作要求
     */
    private String recruitment_jobrequirements;
    /**
     * 工作标签，用于工作类型推荐
     */
    private String recruitment_label;

    private Integer business_id;

    private String business_name;

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

    public String getRecruitment_area() {
        return recruitment_area;
    }

    public void setRecruitment_area(String recruitment_area) {
        this.recruitment_area = recruitment_area;
    }

    public Double getRecruitment_salary() {
        return recruitment_salary;
    }

    public void setRecruitment_salary(Double recruitment_salary) {
        this.recruitment_salary = recruitment_salary;
    }

    public Integer getRecruitment_num() {
        return recruitment_num;
    }

    public void setRecruitment_num(Integer recruitment_num) {
        this.recruitment_num = recruitment_num;
    }

    public String getRecruitment_time() {
        return recruitment_time;
    }

    public void setRecruitment_time(String recruitment_time) {
        this.recruitment_time = recruitment_time;
    }

    public Integer getRecruitment_duration() {
        return recruitment_duration;
    }

    public void setRecruitment_duration(Integer recruitment_duration) {
        this.recruitment_duration = recruitment_duration;
    }

    public String getRecruitment_welfare() {
        return recruitment_welfare;
    }

    public void setRecruitment_welfare(String recruitment_welfare) {
        this.recruitment_welfare = recruitment_welfare;
    }

    public String getRecruitment_jobcontent() {
        return recruitment_jobcontent;
    }

    public void setRecruitment_jobcontent(String recruitment_jobcontent) {
        this.recruitment_jobcontent = recruitment_jobcontent;
    }

    public String getRecruitment_jobrequirements() {
        return recruitment_jobrequirements;
    }

    public void setRecruitment_jobrequirements(String recruitment_jobrequirements) {
        this.recruitment_jobrequirements = recruitment_jobrequirements;
    }

    public String getRecruitment_label() {
        return recruitment_label;
    }

    public void setRecruitment_label(String recruitment_label) {
        this.recruitment_label = recruitment_label;
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

    public Recruitment() {
    }

    public Recruitment(Integer recruitment_id, String recruitment_name, String recruitment_area, Double recruitment_salary, Integer recruitment_num, String recruitment_time, Integer recruitment_duration, String recruitment_welfare, String recruitment_jobcontent, String recruitment_jobrequirements, String recruitment_label, Integer business_id, String business_name) {
        this.recruitment_id = recruitment_id;
        this.recruitment_name = recruitment_name;
        this.recruitment_area = recruitment_area;
        this.recruitment_salary = recruitment_salary;
        this.recruitment_num = recruitment_num;
        this.recruitment_time = recruitment_time;
        this.recruitment_duration = recruitment_duration;
        this.recruitment_welfare = recruitment_welfare;
        this.recruitment_jobcontent = recruitment_jobcontent;
        this.recruitment_jobrequirements = recruitment_jobrequirements;
        this.recruitment_label = recruitment_label;
        this.business_id = business_id;
        this.business_name = business_name;
    }

	@Override
	public String toString() {
		return "Recruitment [recruitment_id=" + recruitment_id + ", recruitment_name=" + recruitment_name
				+ ", recruitment_area=" + recruitment_area + ", recruitment_salary=" + recruitment_salary
				+ ", recruitment_num=" + recruitment_num + ", recruitment_time=" + recruitment_time
				+ ", recruitment_duration=" + recruitment_duration + ", recruitment_welfare=" + recruitment_welfare
				+ ", recruitment_jobcontent=" + recruitment_jobcontent + ", recruitment_jobrequirements="
				+ recruitment_jobrequirements + ", recruitment_label=" + recruitment_label + ", business_id="
				+ business_id + ", business_name=" + business_name + "]";
	}
    
}