package com.test.jpay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.jpay.dto.CustomerPageResponse;
import com.test.jpay.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * this end point is responsible for get page of customer phone number information 
	 * 
	 * @param page
	 * @param size
	 * @param phonePrefix
	 * @return 
	 */
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<CustomerPageResponse> getCustomerDto(
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "5") Integer size,
			@RequestParam(required = false, defaultValue = "") String phonePrefix) {

		LOGGER.debug("----->start api /getcustomer to get page:{} size :{} of customer Dto", page, size);

		Pageable paging = PageRequest.of(page, size);

		return customerService.getCustomerDto(paging, phonePrefix);

	}

}
