package com.test.jpay.entity;

public class Country {

	private String name;

	private String code;

	private String regex;

	public Country() {
		super();
	}

	public Country(String name, String code, String regex) {
		super();
		this.name = name;
		this.code = code;
		this.regex = regex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", code=" + code + ", regex=" + regex + "]";
	}

}
