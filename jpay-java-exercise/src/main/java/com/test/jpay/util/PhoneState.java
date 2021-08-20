package com.test.jpay.util;

public enum PhoneState {

	VALID("valid"), NOT_VALID("not valid");

	private final String State;

	private PhoneState(String state) {
		State = state;
	}

	public String getState() {
		return State;
	}

}
