package com.api.registration.services;

import com.api.registration.dto.RegistrationRequest;
import com.api.registration.exceptions.DuplicateEntryException;
import com.api.registration.exceptions.IdNotFoundException;
import com.api.registration.exceptions.UnavailableException;
import com.api.registration.models.Registration;

public interface RegService {
	public Registration createReg(RegistrationRequest request) throws UnavailableException;
	public Registration getReg(int regId) throws IdNotFoundException;
}
