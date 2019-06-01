package br.pucrs.ages.mase.user_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    private @Id String id;
    private String photo;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;

    public String getId() {
		return id;
	}

	public String getPhoto() {
		return photo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}
    
}

