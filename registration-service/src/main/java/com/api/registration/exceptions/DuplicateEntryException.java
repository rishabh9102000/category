package com.api.registration.exceptions;

public class DuplicateEntryException extends Exception {
	public DuplicateEntryException (String message) {
		super(message);
	}
}
