package com.chinaebi.pmp.database.entity;

import java.util.Date;

/**
 * 对应表 mer_expand_organization
 * 
 * @author king
 *
 */
public class MerExpandOrganization implements java.io.Serializable {

	private static final long serialVersionUID = 7721768653120198764L;
	
	private int id;/* 对应表中id */
	private String organizationName;/* 对应表中organization_name */
	private String organizationAddress;/* 对应表中organization_address */
	private String abbreviation;/* 对应表中abbreviation */
	private String linkman;/* 对应表中linkman */
	private String address;/* 对应表中address */
	private String phone;/* 对应表中phone */
	private Date createTime;/* 对应表中create_time */
	private int state;/* 对应表中state */
	private String remark;/* 对应表中remark */
	private int parentId;/* 对应表中parent_id */
	private int grade;/* 对应表中grade */
	private String agentId;/* 对应表中agent_id */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationAddress() {
		return organizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
}
