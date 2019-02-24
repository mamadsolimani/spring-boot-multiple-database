package com.devglan.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.devglan.model.BranchEntity;

public interface BranchDao extends CrudRepository<BranchEntity, Long> {

    // getAreas
    @Query(value = "SELECT * FROM COMMON.TB_BRANCH branch where branch.FK_LKP_UNIT_TYPE = :typeCode and void_date is null", nativeQuery = true)
    public List<BranchEntity> findBranchsByType(@Param("typeCode") int typeCode);

    // getSubBranches
    @Query(value = "SELECT * FROM COMMON.TB_BRANCH branch where branch.FK_BRC_OPR_OFFICE_BRANCH = :branchId AND branch.FK_LKP_UNIT_TYPE = :type and void_date is null", nativeQuery = true)
    public List<BranchEntity> findSubsetBranchsByFk(@Param("branchId") long branchId, @Param("type") int type );
    
    
    
    
    //-------------------------------------------------------------
    
    @Query(value = "SELECT * FROM COMMON.TB_BRANCH", nativeQuery = true)
    public List<BranchEntity> findAll();
    
    // getBranch
    @Query(value = "SELECT * FROM COMMON.TB_BRANCH branch where branch.id = :branchId", nativeQuery = true)
    public BranchEntity getBranch(@Param("branchId") long parentId);
}
