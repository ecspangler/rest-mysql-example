package org.example.validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Customer;
import org.example.validation.error.ValidationError;

public class CustomerValidation {

	private static final Logger log = LogManager.getLogger(CustomerValidation.class);

	private static final String ERR001_CODE = "ERR001";
	private static final String ERR001_DESC = "Missing Unique Id";
	private static final String ERR002_CODE = "ERR002";
	private static final String ERR002_DESC = "Missing First Name";
	private static final String ERR003_CODE = "ERR003";
	private static final String ERR003_DESC = "Missing Last Name";
	private static final String ERR004_CODE = "ERR004";
	private static final String ERR004_DESC = "Missing Account Number";

	public static List<ValidationError> validate(Customer customer) {
		List<ValidationError> errors = new ArrayList<ValidationError>();

		log.debug("Customer for validation: {}", customer);

		if (customer.getUniqueId() == null || customer.getUniqueId().equals("")) {
			ValidationError error = new ValidationError();
			error.setErrorCode(ERR001_CODE);
			error.setErrorDescription(ERR001_DESC);
			errors.add(error);
		}
		if (customer.getFirstName() == null || customer.getFirstName().equals("")) {
			ValidationError error = new ValidationError();
			error.setErrorCode(ERR002_CODE);
			error.setErrorDescription(ERR002_DESC);
			errors.add(error);
		}
		if (customer.getLastName() == null || customer.getLastName().equals("")) {
			ValidationError error = new ValidationError();
			error.setErrorCode(ERR003_CODE);
			error.setErrorDescription(ERR003_DESC);
			errors.add(error);
		}
		if (customer.getAccountNumber() == null || customer.getAccountNumber().equals("")) {
			ValidationError error = new ValidationError();
			error.setErrorCode(ERR004_CODE);
			error.setErrorDescription(ERR004_DESC);
			errors.add(error);
		}

		return errors;
	}
}
