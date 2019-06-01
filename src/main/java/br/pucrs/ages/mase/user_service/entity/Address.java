package br.pucrs.ages.mase.user_service.entity;

import br.pucrs.ages.mase.user_service.type.State;

public class Address {
	
	private State state;
	private String city;
	private String street;
	private String number;
	
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
