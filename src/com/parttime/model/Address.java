package com.parttime.model;

/**
 * @author 咚咚dongdong
 * Date: 2020/7/16
 * Time: 16:25
 */
@SuppressWarnings(value = "all")
public class Address {
    private int address_id;

    private String address_province;

    private String address_city;

    private String address_county;

    private String address_detail;

    private int employee_id;

    private int business_id;

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
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

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public Address() {
    }

    public Address(int address_id, String address_province, String address_city, String address_county, String address_detail, int employee_id, int business_id) {
        this.address_id = address_id;
        this.address_province = address_province;
        this.address_city = address_city;
        this.address_county = address_county;
        this.address_detail = address_detail;
        this.employee_id = employee_id;
        this.business_id = business_id;
    }

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address_province=" + address_province + ", address_city="
				+ address_city + ", address_county=" + address_county + ", address_detail=" + address_detail
				+ ", employee_id=" + employee_id + ", business_id=" + business_id + "]";
	}
    
}
