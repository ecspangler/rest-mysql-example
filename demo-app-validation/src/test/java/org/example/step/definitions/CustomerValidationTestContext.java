package org.example.step.definitions;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Customer;
import org.example.validation.CustomerValidation;
import org.example.validation.error.ValidationError;

public class CustomerValidationTestContext {

	private Customer customer = new Customer();
	private List<ValidationError> errors = new ArrayList<ValidationError>();
	private CustomerValidation customerValidation = new CustomerValidation();

	public void execute() {
		errors = CustomerValidation.validate(customer);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ValidationError> getErrors() {
		return errors;
	}

	public void setErrors(List<ValidationError> errors) {
		this.errors = errors;
	}

	public CustomerValidation getCustomerValidation() {
		return customerValidation;
	}

	public void setCustomerValidation(CustomerValidation customerValidation) {
		this.customerValidation = customerValidation;
	}

}
