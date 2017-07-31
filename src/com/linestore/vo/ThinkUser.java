package com.linestore.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * ThinkUser entity. @author MyEclipse Persistence Tools
 */

public class ThinkUser implements java.io.Serializable {

	// Fields

	private Integer thuId;
	private String thuUsername;
	private String thuPassword;
	private String thuStatus;
	private Integer thuPid;
	private String thuArea;
	private String thuEmail;
	private String thuPhone;
	private String thuName;
	private Float thuScale;
	private Set groupAccesses = new HashSet(0);

	// Constructors

	/** default constructor */
	public ThinkUser() {
	}
	
	public ThinkUser(ThinkUser thu) {
		this.thuId = thu.getThuId();
		this.thuUsername = thu.getThuUsername();
		this.thuPassword = thu.getThuPassword();
		this.thuStatus = thu.getThuStatus();
		this.thuPid = thu.getThuPid();
		this.thuArea = thu.getThuArea();
		this.thuEmail = thu.getThuEmail();
		this.thuPhone = thu.getThuPhone();
		this.thuName = thu.getThuName();
		this.thuScale = thu.getThuScale();
	}

	/** minimal constructor */
	public ThinkUser(String thuUsername, String thuPassword, String thuStatus) {
		this.thuUsername = thuUsername;
		this.thuPassword = thuPassword;
		this.thuStatus = thuStatus;
	}

	/** full constructor */
	public ThinkUser(String thuUsername, String thuPassword, String thuStatus, Integer thuPid, String thuArea,
			String thuEmail, String thuPhone, String thuName, Float thuScale, Set groupAccesses) {
		this.thuUsername = thuUsername;
		this.thuPassword = thuPassword;
		this.thuStatus = thuStatus;
		this.thuPid = thuPid;
		this.thuArea = thuArea;
		this.thuEmail = thuEmail;
		this.thuPhone = thuPhone;
		this.thuName = thuName;
		this.thuScale = thuScale;
		this.groupAccesses = groupAccesses;
	}

	// Property accessors

	public Integer getThuId() {
		return this.thuId;
	}

	public void setThuId(Integer thuId) {
		this.thuId = thuId;
	}

	public String getThuUsername() {
		return this.thuUsername;
	}

	public void setThuUsername(String thuUsername) {
		this.thuUsername = thuUsername;
	}

	public String getThuPassword() {
		return this.thuPassword;
	}

	public void setThuPassword(String thuPassword) {
		this.thuPassword = thuPassword;
	}

	public String getThuStatus() {
		return this.thuStatus;
	}

	public void setThuStatus(String thuStatus) {
		this.thuStatus = thuStatus;
	}

	public Integer getThuPid() {
		return this.thuPid;
	}

	public void setThuPid(Integer thuPid) {
		this.thuPid = thuPid;
	}

	public String getThuArea() {
		return this.thuArea;
	}

	public void setThuArea(String thuArea) {
		this.thuArea = thuArea;
	}

	public String getThuEmail() {
		return this.thuEmail;
	}

	public void setThuEmail(String thuEmail) {
		this.thuEmail = thuEmail;
	}

	public String getThuPhone() {
		return this.thuPhone;
	}

	public void setThuPhone(String thuPhone) {
		this.thuPhone = thuPhone;
	}

	public String getThuName() {
		return this.thuName;
	}

	public void setThuName(String thuName) {
		this.thuName = thuName;
	}

	public Float getThuScale() {
		return this.thuScale;
	}

	public void setThuScale(Float thuScale) {
		this.thuScale = thuScale;
	}

	public Set getGroupAccesses() {
		return this.groupAccesses;
	}

	public void setGroupAccesses(Set groupAccesses) {
		this.groupAccesses = groupAccesses;
	}

}