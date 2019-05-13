package br.pucrs.ages.mase.user_service.dto;

import javax.validation.constraints.NotEmpty;

import br.pucrs.ages.mase.user_service.type.State;

public class AddressDto {
	
	private @NotEmpty State state;
	private @NotEmpty String city;
	private @NotEmpty String street;
	private @NotEmpty String number;
	
	public State getState() {
		return state;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getNumber() {
		return number;
	}
	
}
