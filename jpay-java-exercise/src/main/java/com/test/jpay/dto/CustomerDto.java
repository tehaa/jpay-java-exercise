package com.test.jpay.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

	private String name;
	private String fullPhoneNumber;
	private String countryName;
	private String state;
	private String countryCode;
	private String number;

	public CustomerDto() {
		super();
	}

	public CustomerDto(String name, String fullPhoneNumber, String countryName, String state, String countryCode,
			String number) {
		super();
		this.name = name;
		this.fullPhoneNumber = fullPhoneNumber;
		this.countryName = countryName;
		this.state = state;
		this.countryCode = countryCode;
		this.number = number;
	}

	public CustomerDto(String name, String fullPhoneNumber) {
		super();
		this.name = name;
		this.fullPhoneNumber = fullPhoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullPhoneNumber() {
		return fullPhoneNumber;
	}

	public void setFullPhoneNumber(String fullPhoneNumber) {
		this.fullPhoneNumber = fullPhoneNumber;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", fullPhoneNumber=" + fullPhoneNumber + ", countryName=" + countryName
				+ ", state=" + state + ", countryCode=" + countryCode + ", number=" + number + "]";
	}
	
	

}
