package com.devglan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.devglan.model.dto.AreaDto;
import com.devglan.model.dto.BranchDto;
import com.devglan.model.dto.BranchLiteDto;
import com.devglan.model.dto.CenterDto;
import com.devglan.model.dto.WicketDto;

@Entity
@Table(name = "TB_BRANCH", schema = "COMMON")
public class BranchEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "UNIT_NAME")
	private String name;

	@Column(name = "UNIT_CODE")
	private Integer code;
	
	@Column(name = "FK_LKP_UNIT_TYPE")
	private Integer type;
	
	@Column(name = "FK_BRC_OPR_OFFICE_BRANCH")
	private Integer parentId;

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
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public CenterDto toCenterDto() {
        CenterDto dto = new CenterDto();
        dto.setId(this.id);
        dto.setName( this.name.trim() );
        dto.setCode(this.code);

        return dto;
    }

    public AreaDto toAreaDto() {
        AreaDto dto = new AreaDto();
        dto.setId(this.id);
        dto.setName( this.name.trim() );
        dto.setCode(this.code);

        return dto;
    }

	public BranchDto toBranchDto() {
		BranchDto dto = new BranchDto();
		dto.setId(this.id);
		dto.setName( this.name.trim() );
		dto.setCode(this.code);

		return dto;
	}

	public WicketDto toWicketDto() {
		WicketDto dto = new WicketDto();
		dto.setId(this.id);
		dto.setName( this.name.trim() );
		dto.setCode(this.code);

		return dto;
	}
	
	public BranchLiteDto toDtoLite() {
		BranchLiteDto dto = new BranchLiteDto();
		dto.setId(this.id);
		dto.setName( this.name.trim() );
		dto.setCode(this.code);

		return dto;
	}
	
	public void fromDto(BranchDto dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.code = dto.getCode();

	}

	@Override
	public String toString() {
		
		return "id:" + this.id + ", name:" + this.name.trim() + ", code:" + this.code + ", parentId:" + this.parentId;
	}
	
}
