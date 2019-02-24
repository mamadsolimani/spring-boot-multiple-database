/**
 * 
 */
package com.devglan.service;

import java.util.List;

import com.devglan.model.dto.AreaDto;
import com.devglan.model.dto.BranchLiteDto;

public interface BranchService {
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<AreaDto> findTreeBranches() throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<BranchLiteDto> findAll() throws Exception;
	
	/**
	 * 
	 * @throws Exception
	 */
	public String insert() throws Exception;
	
}
