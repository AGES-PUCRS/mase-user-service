package br.pucrs.ages.mase.user_service.entity;

import br.pucrs.ages.mase.user_service.type.CivilDefenseRole;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.FieldValue;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;

@Document(collection = "civildefenseofficials")
public class CivilDefenseOfficial extends User {

	private String office;
	private @Indexed String institutionalLink;
	private boolean active;
	private @NotEmpty CivilDefenseRole civilDefenseRole;

	public String getOffice() {
		return office;
	}

	public String getInstitutionalLink() {
		return institutionalLink;
	}

	public boolean isActive() {
		return active;
	}

	public CivilDefenseRole getCivilDefenseRole() {
		return civilDefenseRole;
	}
}
