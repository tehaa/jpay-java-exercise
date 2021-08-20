package com.test.jpay.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.test.jpay.entity.Country;

@Service
public class CountryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

	//map where key is prefix of phone number and value is country information
	public static final Map<String, Country> COUNTRY_CODE; 

	static {
		COUNTRY_CODE = new HashMap<String, Country>();

		LOGGER.debug("----->start fill country code map");
		COUNTRY_CODE.put("(237)", new Country("Cameroon", "+237", "^\\(237\\)\\ ?[2368]\\d{7,8}$"));
		COUNTRY_CODE.put("(251)", new Country("Ethiopia", "+251", "^\\(251\\)\\ ?[1-59]\\d{8}$"));
		COUNTRY_CODE.put("(212)", new Country("Morocco", "+212", "^\\(212\\)\\ ?[5-9]\\d{8}$"));
		COUNTRY_CODE.put("(258)", new Country("Mozambique", "+258", "^\\(258\\)\\ ?[28]\\d{7,8}$"));
		COUNTRY_CODE.put("(256)", new Country("Uganda", "+256", "^\\(256\\)\\ ?\\d{9}$"));

		LOGGER.debug("----->country code map is filled with this values : {}", COUNTRY_CODE);

	}
}
