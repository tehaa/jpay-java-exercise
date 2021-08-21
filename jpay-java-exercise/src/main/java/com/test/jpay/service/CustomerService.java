package com.test.jpay.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.jpay.dto.CustomerPhoneDto;
import com.test.jpay.dto.CustomerPhonePage;
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
	 * this method get page of customer by phone number prefix and then we used the
	 * static map in country service to get phone number information and check by
	 * country regex if phone valid or not
	 * 
	 * @param paging
	 * @param phonePrefix
	 * @return CustomerPhonePage
	 */
	public ResponseEntity<CustomerPhonePage> getCustomerPhonePage(Pageable paging, String phonePrefix) {
		LOGGER.debug("-----> Started service method [getCustomerPhonePage] to get customer  phone which start by :{} ",
				phonePrefix);

		// get page of customer by pageable object and phone prefix
		Page<Customer> customers = customerRepo.findByPhoneContaining(phonePrefix, paging);

		// construct customer phone page info from customer page object
		CustomerPhonePage customerPageResponse = new CustomerPhonePage(customers.getNumber(), customers.getSize(),
				customers.getTotalElements());

		if (customers.getContent().size() != 0) {

			List<CustomerPhoneDto> customerPhoneDtos = constructCustomersPhoneFromCustomers(customers.getContent());

			customerPageResponse.setCustomerPhoneDtos(customerPhoneDtos);

			return ResponseEntity.status(HttpStatus.OK).body(customerPageResponse);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

	}

	/**
	 * this method stream on list of customers and construct customer phone object
	 * from each customer then collect this objects to list
	 * 
	 * @param customers
	 * @return
	 */
	private List<CustomerPhoneDto> constructCustomersPhoneFromCustomers(List<Customer> customers) {
		return customers.stream().map(cus -> {

			CustomerPhoneDto customerDto = constructCustomerPhoneFromCustomer(cus);
			return customerDto;

		}).collect(Collectors.toList());
	}

	/**
	 * this method construct customer phone number information from customer phone
	 * number we divide the phone number to prefix and number and then we use this
	 * prefix to get country information from the static map that in [country
	 * service ]where key is prefix and value is country information
	 * 
	 * @param customer
	 * @return
	 */
	private CustomerPhoneDto constructCustomerPhoneFromCustomer(Customer customer) {

		LOGGER.debug("----->start construct customer phone Dto from customer : {}", customer);
		CustomerPhoneDto customerPhoneDto = new CustomerPhoneDto(customer.getName(), customer.getPhone());

		// spilt customer phone number to prefix and phone number
		String[] phoneInfo = customer.getPhone().split(" ");

		customerPhoneDto.setNumber(phoneInfo[1]);

		LOGGER.debug("----->get country from map where phone prefix is : {} ", phoneInfo[0]);
		Country country = CountryService.COUNTRY_CODE.get(phoneInfo[0]);

		if (Objects.nonNull(country)) {

			LOGGER.info("----->country : {} where prefix is : {} is returned from map ", country, phoneInfo[0]);
			customerPhoneDto.setCountryCode(country.getCode());
			customerPhoneDto.setCountryName(country.getName());

			// check if customer phone match country regex and set state depend on this
			// matching
			if (customer.getPhone().matches(country.getRegex())) {

				customerPhoneDto.setState(PhoneState.VALID.getState());
			} else {
				customerPhoneDto.setState(PhoneState.NOT_VALID.getState());

			}
		}
		return customerPhoneDto;
	}

}
