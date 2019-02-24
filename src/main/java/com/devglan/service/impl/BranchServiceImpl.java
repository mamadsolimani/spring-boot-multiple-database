/**
 * 
 */
package com.devglan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.booking.dao.BranchDao;
import com.devglan.model.BranchEntity;
import com.devglan.model.BranchInsert;
import com.devglan.model.dto.AreaDto;
import com.devglan.model.dto.BranchDto;
import com.devglan.model.dto.BranchLiteDto;
import com.devglan.model.dto.CenterDto;
import com.devglan.model.dto.WicketDto;
import com.devglan.service.BranchService;
import com.devglan.user.dao.GLDao;

@Service
public class BranchServiceImpl implements BranchService {
	
	public static final Logger log = LoggerFactory.getLogger(BranchServiceImpl.class);
	
	@Autowired
	private GLDao glDao;
	
	@Autowired
	private BranchDao branchDao;

	@Override
	public List<AreaDto> findTreeBranches() throws Exception {
		
		log.debug("Entering findTreeBranches() ");
		
		int areasCode = 1018;
        int typeCenter = 1012;
        int typeBranch = 1011;
        int typeWicket = 1016;
		
        List<AreaDto> areaResult = new ArrayList<>();
        
		List<BranchEntity> areas = null;
        List<BranchEntity> centers = null;
        List<BranchEntity> branches = null;
        List<BranchEntity> wickets = null;
        
        try {
        	
        	areas = branchDao.findBranchsByType(areasCode);
            
            for(BranchEntity area : areas) {

                List<CenterDto> centerDtos = new ArrayList<>();
                centers = branchDao.findSubsetBranchsByFk( area.getId(), typeCenter );
                for (BranchEntity center : centers) {

                    List<BranchDto> branchDtos = new ArrayList<>();
                    branches = branchDao.findSubsetBranchsByFk( center.getId(), typeBranch );
                    for (BranchEntity branch : branches) {
                    	
                    	List<WicketDto> wicketDtos = new ArrayList<>();
                    	wickets = branchDao.findSubsetBranchsByFk( branch.getId(), typeWicket );
                    	for (BranchEntity wicket : wickets) {
                    		wicketDtos.add( wicket.toWicketDto() );
                    	}
                    	
                    	BranchDto branchDto = branch.toBranchDto();
                    	branchDto.setWickets(wicketDtos);
                    	
                    	branchDtos.add( branchDto );
                    }

                    CenterDto centerDto = center.toCenterDto();
                    centerDto.setBranches( branchDtos );

                    centerDtos.add(centerDto);
                }

                AreaDto areaDto = area.toAreaDto();
                areaDto.setCenters(centerDtos);

                areaResult.add( areaDto );
            }
        	
        } catch (Exception e) {
        	throw new Exception("Error occurred while calling findTreeBranches().", e);
		}
        
		return areaResult;
	}

	@Override
	public List<BranchLiteDto> findAll() throws Exception {
		
		log.debug("Entering findAll() ");

		List<BranchLiteDto> result = new ArrayList<>();
		
		try {
			
			List<BranchEntity> branchs = branchDao.findAll();
			for (BranchEntity branch : branchs) {
				result.add( branch.toDtoLite() );
			}
			
		} catch (Exception e) {
			throw new Exception("Error occurred while calling findAll().", e);
		}
		
		return result;
	}

	@Override
	public String insert() throws Exception {
		
		log.debug("Entering insert() ");
		
		Integer areasCode = 1018;
		Integer typeCenter = 1012;
		Integer typeOffice = 1013;
		Integer typeBranch = 1011;
		Integer typeWicket = 1016;
		
		try {
			
			List<BranchEntity> branches = branchDao.findAll();
			
//			glDao.deleteAll();
			
			for (BranchEntity branch : branches) {
				
				BranchInsert branchInsert = new BranchInsert();
				branchInsert.setName( branch.getName().trim() );
				branchInsert.setCode( branch.getCode() );
				
				Integer branchType = branch.getType();
				if ( branchType.equals(areasCode) ) {
					
					branchInsert.setBranchParentCode( branch.getCode() );
					
				} else if ( branchType.equals(typeCenter) || branchType.equals(typeOffice) ) {
					
					branchInsert.setBranchParentCode( branch.getCode() );
					branchInsert.setCenterCode( branch.getCode() );
					
//					if (  branch.getParentId() != null ) {
//						BranchEntity branchArea = branchDao.getBranch( branch.getParentId() );
//						branchInsert.setAreaCode( branchArea.getCode() );
//					} 
					
					
				} else if ( branchType.equals(typeBranch) ) {
					
					branchInsert.setBranchParentCode( branch.getCode() );
					
					if ( branch.getParentId() != null ) {
						BranchEntity branchCenter = branchDao.getBranch( branch.getParentId() );
						branchInsert.setCenterCode( branchCenter.getCode() );
						
//						if (  branchCenter.getParentId() != null ) {
//							BranchEntity branchArea = branchDao.getBranch( branchCenter.getParentId() );
//							branchInsert.setAreaCode( branchArea.getCode() );
//						}
						
					}
					
				} else if ( branchType.equals(typeWicket) ) {
					
					if ( branch.getParentId() != null ) {
						BranchEntity branchParent = branchDao.getBranch( branch.getParentId() );
						branchInsert.setBranchParentCode( branchParent.getCode() );
						
						if ( branchParent.getParentId() != null ) {
							BranchEntity branchCenter = branchDao.getBranch( branchParent.getParentId() );
							branchInsert.setCenterCode( branchCenter.getCode() );
							
//							if ( branchCenter.getParentId() != null ) {
//								BranchEntity branchArea = branchDao.getBranch( branchCenter.getParentId() );
//								branchInsert.setAreaCode( branchArea.getCode() );
//							}
							
						}
						
					}
					
				}

				glDao.save(branchInsert);
				
			}
			
		} catch (Exception e) {
			throw new Exception("Error occurred while calling insert().", e);
		}
		
		return "success";
	}
	
}
