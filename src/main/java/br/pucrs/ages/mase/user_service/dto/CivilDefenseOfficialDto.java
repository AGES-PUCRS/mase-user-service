package br.pucrs.ages.mase.user_service.dto;

import javax.validation.constraints.NotEmpty;

public class CivilDefenseOfficialDto {
	
	private @NotEmpty String office;
	private @NotEmpty String institutionalLink;
	private boolean active;
	
	public String getOffice() {
		return office;
	}
	
	public String getInstitutionalLink() {
		return institutionalLink;
	}
	
	public boolean isActive() {
		return active;
	}
	
}
