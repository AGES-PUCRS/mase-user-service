package br.pucrs.ages.mase.user_service.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "civildefenseofficials")
public class CivilDefenseOfficial extends User {
	
	private String office;
	private String institutionalLink;
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
