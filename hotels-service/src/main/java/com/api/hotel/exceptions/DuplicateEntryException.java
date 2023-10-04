package com.api.hotel.exceptions;

public class DuplicateEntryException extends Exception {
	public DuplicateEntryException (String message) {
		super(message);
	}
}
