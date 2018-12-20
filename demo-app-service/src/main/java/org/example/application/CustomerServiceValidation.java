package org.example.application;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Customer;
import org.example.service.error.ServiceError;
import org.example.validation.CustomerValidation;
import org.example.validation.error.ValidationError;

public class CustomerServiceValidation {

	public List<ServiceError> validate(Customer customer) {
		List<ServiceError> serviceErrors = new ArrayList<ServiceError>();
		List<ValidationError> validationErrors = CustomerValidation.validate(customer);

		validationErrors.forEach(validationError -> {
			ServiceError serviceError = new ServiceError();
			serviceError.setErrorCode(validationError.getErrorCode());
			serviceError.setErrorDescription(validationError.getErrorDescription());
			serviceErrors.add(serviceError);
		});

		return serviceErrors;

	}
}
