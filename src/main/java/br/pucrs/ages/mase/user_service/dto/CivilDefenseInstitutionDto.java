package br.pucrs.ages.mase.user_service.dto;

import javax.validation.constraints.NotEmpty;

public class CivilDefenseInstitutionDto {

    private String id;
    private @NotEmpty String cnpj;
    private @NotEmpty String name;
    private @NotEmpty String email;
    private @NotEmpty String phoneNumber;
    private @NotEmpty AddressDto address;

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

    public AddressDto getAddress() {
        return address;
    }

}
