package com.test.jpay.dto;

import java.util.List;

public class CustomerPhonePage extends PageDto {

	List<CustomerPhoneDto> customerPhoneDtos;

	public CustomerPhonePage(int number, int size, Long totalElements) {
		super(number, size, totalElements);
	}

	public List<CustomerPhoneDto> getCustomerPhoneDtos() {
		return customerPhoneDtos;
	}

	public void setCustomerPhoneDtos(List<CustomerPhoneDto> customerPhoneDtos) {
		this.customerPhoneDtos = customerPhoneDtos;
	}
	

}
