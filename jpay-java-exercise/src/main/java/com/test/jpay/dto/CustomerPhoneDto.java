package com.test.jpay.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPhoneDto {

	private String name;
	private String fullPhoneNumber;
	private String countryName;
	private String state;
	private String countryCode;
	private String number;

	public CustomerPhoneDto() {
		super();
	}

	public CustomerPhoneDto(String name, String fullPhoneNumber, String countryName, String state, String countryCode,
			String number) {
		super();
		this.name = name;
		this.fullPhoneNumber = fullPhoneNumber;
		this.countryName = countryName;
		this.state = state;
		this.countryCode = countryCode;
		this.number = number;
	}

	public CustomerPhoneDto(String name, String fullPhoneNumber) {
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
		return "CustomerPhoneDto [name=" + name + ", fullPhoneNumber=" + fullPhoneNumber + ", countryName="
				+ countryName + ", state=" + state + ", countryCode=" + countryCode + ", number=" + number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((fullPhoneNumber == null) ? 0 : fullPhoneNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerPhoneDto other = (CustomerPhoneDto) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (fullPhoneNumber == null) {
			if (other.fullPhoneNumber != null)
				return false;
		} else if (!fullPhoneNumber.equals(other.fullPhoneNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
