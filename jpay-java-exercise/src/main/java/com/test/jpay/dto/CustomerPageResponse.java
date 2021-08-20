package com.test.jpay.dto;

import java.util.List;

public class CustomerPageResponse extends PageDto {

	List<CustomerDto> customerDtos;

	public CustomerPageResponse(int number, int size, Long totalElements) {
		super(number, size, totalElements);
	}

	public List<CustomerDto> getCustomerDtos() {
		return customerDtos;
	}

	public void setCustomerDtos(List<CustomerDto> customerDtos) {
		this.customerDtos = customerDtos;
	}

	@Override
	public String toString() {
		return "CustomerPageResponse [customerDtos=" + customerDtos + "]";
	}

}
