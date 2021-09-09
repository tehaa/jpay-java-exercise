package com.test.jpay;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import com.test.jpay.controller.CustomerController;
import com.test.jpay.dto.CustomerPhoneDto;
import com.test.jpay.entity.Customer;
import com.test.jpay.repository.CustomerRepo;
import com.test.jpay.service.CustomerService;

public class CustomerControllerTest {

	@Autowired
	CustomerController customerController;

	@InjectMocks
	CustomerService customerService;

	@Mock
	private CustomerRepo customerRepo;

	@BeforeEach
	private void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetCustomers() {
		Pageable paging = PageRequest.of(0, 2);
		
		

		Customer customer1 = new Customer(1, "Ahmed", "(212) 6007989253");
		Customer customer2 = new Customer(2, "Mohamed", "(212) 698054317");

		List<Customer> customers = new LinkedList<Customer>();
		customers.add(customer1);
		customers.add(customer2);

		Page<Customer> cusPage = new PageImpl<>(customers);
		
		List<Customer> emptyCustomerList=new LinkedList<Customer>();
		Page<Customer> emptycusPage = new PageImpl<>(emptyCustomerList);

		when(customerRepo.findByPhoneStartingWith("", paging)).thenReturn(cusPage);

		when(customerRepo.findByPhoneStartingWith("(123)", paging)).thenReturn(emptycusPage);

		CustomerPhoneDto customerPhoneDto = new CustomerPhoneDto("Ahmed", "(212) 6007989253", "Morocco", "not valid",
				"+212", "6007989253");

		CustomerPhoneDto customerPhoneDto2 = new CustomerPhoneDto("Mohamed", "(212) 698054317", "Morocco", "valid",
				"+212", "698054317");

		List<CustomerPhoneDto> customerPhoneDtos = new LinkedList<CustomerPhoneDto>();
		customerPhoneDtos.add(customerPhoneDto);
		customerPhoneDtos.add(customerPhoneDto2);

		assertAll(() -> assertEquals(customerPhoneDtos,
				customerService.getCustomerPhonePage(paging, "").getBody().getCustomerPhoneDtos()),
				() -> assertEquals(HttpStatus.NO_CONTENT,
						customerService.getCustomerPhonePage(paging, "(123)").getStatusCode()));

	}
}
