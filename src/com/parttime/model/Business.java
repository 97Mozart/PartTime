package com.parttime.model;

/**
 * (Business)实体类
 *
 * @author makejava
 * @since 2020-07-13 14:37:38
 */
@SuppressWarnings(value = "all")
public class Business {

    private Integer business_id;

    private String business_name;

    private String business_tell;

    private String business_email;

    private String business_password;
    /**
     * 商家账户
     */
    private String business_account;
    /**
     * 使用外键地址表，表已创建
     */
    private Integer address_id;

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

    public String getBusiness_tell() {
        return business_tell;
    }

    public void setBusiness_tell(String business_tell) {
        this.business_tell = business_tell;
    }

    public String getBusiness_email() {
        return business_email;
    }

    public void setBusiness_email(String business_email) {
        this.business_email = business_email;
    }

    public String getBusiness_password() {
        return business_password;
    }

    public void setBusiness_password(String business_password) {
        this.business_password = business_password;
    }

    public String getBusiness_account() {
        return business_account;
    }

    public void setBusiness_account(String business_account) {
        this.business_account = business_account;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer addressId) {
        this.address_id = addressId;
    }

    public Business() {
    }

    public Business(Integer business_id, String business_name, String business_tell, String business_email, String business_password, String business_account, Integer address_id) {
        this.business_id = business_id;
        this.business_name = business_name;
        this.business_tell = business_tell;
        this.business_email = business_email;
        this.business_password = business_password;
        this.business_account = business_account;
        this.address_id = address_id;
    }

	@Override
	public String toString() {
		return "Business [business_id=" + business_id + ", business_name=" + business_name + ", business_tell="
				+ business_tell + ", business_email=" + business_email + ", business_password=" + business_password
				+ ", business_account=" + business_account + ", address_id=" + address_id + "]";
	}
    
}