package com.test.jpay.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.jpay.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Page<Customer> findByPhoneContaining(String phonePrefix, Pageable paging);
}
