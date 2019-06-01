package br.pucrs.ages.mase.user_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "civildefenseinstitutions")
public class CivilDefenseInstitution {
	
	private @Id String id;
	private String cnpj;
	private @Indexed(unique = true) String name;
	private String email;
	private String phoneNumber;
	private Address address;
	
	public String getId() {
		return id;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Address getAddress() {
		return address;
	}
	
}
