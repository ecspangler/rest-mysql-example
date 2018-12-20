package org.example.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.model.Customer;

@XmlRootElement(name = "CreateCustomerRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateCustomerRequest {

	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
