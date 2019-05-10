package br.pucrs.ages.mase.user_service.dto;

import javax.validation.constraints.NotEmpty;

public class VolunteerDto extends UserDto {
	
	private @NotEmpty String occupation;
	private @NotEmpty String councilNumber;
	private @NotEmpty String institutionalLink;
	
	public String getOccupation() {
		return occupation;
	}
	
	public String getCouncilNumber() {
		return councilNumber;
	}
	
	public String getInstitutionalLink() {
		return institutionalLink;
	}
	
}
