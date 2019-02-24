package com.devglan.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH_REL", schema = "BNGL")
public class BranchInsert implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", insertable = false, updatable = false)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BRANCH_CODE")
	private Integer code;

	@Column(name = "BRANCH_PARENT_CODE")
	private Integer branchParentCode;

	@Column(name = "CENTER_CODE")
	private Integer centerCode;

	@Column(name = "AREA_CODE")
	private Integer areaCode;

	@Column(name = "UPDATE_DATE", insertable = false)
	private Timestamp updateDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getBranchParentCode() {
		return branchParentCode;
	}

	public void setBranchParentCode(Integer branchParentCode) {
		this.branchParentCode = branchParentCode;
	}

	public Integer getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(Integer centerCode) {
		this.centerCode = centerCode;
	}

	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

}
