package com.test.jpay.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.jpay.dto.CustomerDto;
import com.test.jpay.dto.CustomerPageResponse;
import com.test.jpay.entity.Country;
import com.test.jpay.entity.Customer;
import com.test.jpay.repository.CustomerRepo;
import com.test.jpay.util.PhoneState;

@Service
public class CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepo customerRepo;

	/**
	 * 
	 * @param paging
	 * @param phonePrefix
	 * @return
	 */
	public ResponseEntity<CustomerPageResponse> getCustomerDto(Pageable paging, String phonePrefix) {
		LOGGER.debug("-----> Started service method [getCustomerDto] to get customer dto ");

		Page<Customer> customers = customerRepo.findByPhoneContaining(phonePrefix, paging);

		CustomerPageResponse customerPageResponse = new CustomerPageResponse(customers.getNumber(), customers.getSize(),
				customers.getTotalElements());

		if (customers.getContent().size() != 0) {
			List<CustomerDto> customerDtos = constructCustomerDtoListFromCustomerList(customers.getContent());

			customerPageResponse.setCustomerDtos(customerDtos);

			return ResponseEntity.status(HttpStatus.OK).body(customerPageResponse);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

	}

	/**
	 * 
	 * @param customers
	 * @return
	 */
	private List<CustomerDto> constructCustomerDtoListFromCustomerList(List<Customer> customers) {
		return customers.stream().map(cus -> {

			CustomerDto customerDto = constructCustomerDtoFromCustomer(cus);
			return customerDto;

		}).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param customer
	 * @return
	 */
	private CustomerDto constructCustomerDtoFromCustomer(Customer customer) {
		CustomerDto customerDto = new CustomerDto(customer.getName(), customer.getPhone());

		customerDto.setNumber(customer.getPhone().split(" ")[1]);

		String code = null;

		for (String s : CountryService.COUNTRY_CODE.keySet()) {

			if (customer.getPhone().split(" ")[0].contains(s)) {
				code = s;
			}

		}
		Country country = CountryService.COUNTRY_CODE.get(code);

		customerDto.setCountryCode(country.getCode());
		customerDto.setCountryName(country.getName());

		if (customer.getPhone().matches(country.getRegex())) {

			customerDto.setState(PhoneState.VALID.getState());
		} else {
			customerDto.setState(PhoneState.NOT_VALID.getState());

		}

		return customerDto;
	}

}
