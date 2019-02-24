package com.devglan.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AreaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String name;
    private Integer code;

    private List<CenterDto> centers = new ArrayList<>();

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

    public List<CenterDto> getCenters() {
        return centers;
    }

    public void setCenters(List<CenterDto> centers) {
        this.centers = centers;
    }

}
