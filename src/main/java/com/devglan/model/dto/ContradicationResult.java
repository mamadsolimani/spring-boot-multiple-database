/**
 * @author Mohammad Mohammad Soleimani
 */
package com.devglan.model.dto;

public class ContradicationResult {

	private Iterable<BranchDto> diffrenceGlList;
	private Iterable<BranchDto> diffrenceTstList;

	public Iterable<BranchDto> getDiffrenceGlList() {
		return diffrenceGlList;
	}

	public void setDiffrenceGlList(Iterable<BranchDto> diffrenceGlList) {
		this.diffrenceGlList = diffrenceGlList;
	}

	public Iterable<BranchDto> getDiffrenceTstList() {
		return diffrenceTstList;
	}

	public void setDiffrenceTstList(Iterable<BranchDto> diffrenceTstList) {
		this.diffrenceTstList = diffrenceTstList;
	}

}
