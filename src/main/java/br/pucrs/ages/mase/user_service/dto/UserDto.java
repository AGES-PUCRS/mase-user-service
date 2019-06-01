package br.pucrs.ages.mase.user_service.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotEmpty;

public class UserDto {

    private String id;
    private @NotEmpty String photo;
    private @NotEmpty String phoneNumber;
    private @NotEmpty String firstName;
    private @NotEmpty String lastName;
    private @NotEmpty String email;
    private @NotEmpty String cpf;
    
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

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
