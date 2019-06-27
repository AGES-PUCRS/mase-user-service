package br.pucrs.ages.mase.user_service.dto;

import br.pucrs.ages.mase.user_service.type.CivilDefenseRole;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CivilDefenseOfficialDto extends UserDto {

    private @NotEmpty String office;
    private @NotEmpty String institutionalLink;
    private boolean active;
    private @NotNull CivilDefenseRole civilDefenseRole;


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

    public void setActive(boolean active) {
        this.active = active;
    }
}
