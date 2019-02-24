package com.devglan.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CenterDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private Integer code;

    private List<BranchDto> branches = new ArrayList<>();

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

    public List<BranchDto> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDto> branches) {
        this.branches = branches;
    }

}