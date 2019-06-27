package br.pucrs.ages.mase.user_service.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VolunteerDto extends UserDto {

    private @NotEmpty String occupation;
    private @NotEmpty String councilNumber;
    private @NotEmpty String institutionalLink;
    private @Valid @NotNull LocationDto lastLocation;

    public String getOccupation() {
        return occupation;
    }

    public String getCouncilNumber() {
        return councilNumber;
    }

    public String getInstitutionalLink() {
        return institutionalLink;
    }

    public LocationDto getLastLocation() {
        return lastLocation;
    }

}
