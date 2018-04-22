package service.reg.entity;

import java.io.Serializable;

import service.reg.enums.TenantSexEnum;

public class TenantEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String tenantId;
	private String tenantAccount;
	private String tenantPassword;
	private String tenantName;
	private TenantSexEnum tenantSex;
	private String tenantBirthday;
	private String tel;
	private String email;
	private String company;
	private String address;
	private String businessTypeId;
	private String parentTenantId;
	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getTenantAccount() {
		return tenantAccount;
	}
	public void setTenantAccount(String tenantAccount) {
		this.tenantAccount = tenantAccount;
	}
	public String getTenantPassword() {
		return tenantPassword;
	}
	public void setTenantPassword(String tenantPassword) {
		this.tenantPassword = tenantPassword;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getTenantBirthday() {
		return tenantBirthday;
	}
	public void setTenantBirthday(String tenantBirthday) {
		this.tenantBirthday = tenantBirthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public TenantSexEnum getTenantSex() {
		return tenantSex;
	}
	public void setTenantSex(TenantSexEnum tenantSex) {
		this.tenantSex = tenantSex;
	}
	public String getBusinessTypeId() {
		return businessTypeId;
	}
	public void setBusinessTypeId(String businessTypeId) {
		this.businessTypeId = businessTypeId;
	}
	public String getParentTenantId() {
		return parentTenantId;
	}
	public void setParentTenantId(String parentTenantId) {
		this.parentTenantId = parentTenantId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
}