package com.devglan.user.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.devglan.model.BranchInsert;

public interface GLDao extends CrudRepository<BranchInsert, Long> {
	
	@Query( value = "DELETE FROM BNGL.BRANCH_REL WHERE ID > 0", nativeQuery = true)
	public void deleteAll();
	
}
