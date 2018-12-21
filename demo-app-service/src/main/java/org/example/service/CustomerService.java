package org.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.repository.CustomerRepository;
import org.example.application.CustomerServiceValidation;
import org.example.model.Customer;
import org.example.service.model.CreateCustomerResponse;
import org.example.service.model.GetCustomerResponse;
import org.example.service.model.GetCustomersResponse;

@Path("/customers")
public class CustomerService {

	private static final Logger log = LogManager.getLogger(CustomerService.class);

	private CustomerRepository customerRepository = new MySqlCustomerRepository();
	private CustomerServiceValidation customerServiceValidation = new CustomerServiceValidation();

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public CreateCustomerResponse createCustomer(Customer customer) {
		CreateCustomerResponse response = new CreateCustomerResponse();
		// In a real application we wouldn't log the full request at info level
		log.info("Creating customer: {}", customer);

		response.setErrors(customerServiceValidation.validate(customer));
//		if (response.getErrors().isEmpty()) {
//			customerRepository.addCustomer(customer);
//		}

		return response;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public GetCustomersResponse getAllCustomers() {
		GetCustomersResponse response = new GetCustomersResponse();
		log.info("Retrieving all Customers");

		// response.setCustomers(customerRepository.getAllCustomers());
		Customer cust1 = makeDummyCustomer();
		Customer cust2 = makeDummyCustomer();
		cust2.setUniqueId("A00002");
		cust2.setLastName("Smith II");
		Customer cust3 = makeDummyCustomer();
		cust3.setUniqueId("A00003");
		cust3.setLastName("Smith III");

		List<Customer> dummyCustomers = new ArrayList<Customer>();
		dummyCustomers.add(cust1);
		dummyCustomers.add(cust2);
		dummyCustomers.add(cust3);

		response.setCustomers(dummyCustomers);

		return response;
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public GetCustomerResponse getCustomer(@PathParam("id") String id) {
		GetCustomerResponse response = new GetCustomerResponse();
		log.info("Retrieving Customer with id: {}", id);

		response.setCustomer(makeDummyCustomer());

		return response;
	}

	private Customer makeDummyCustomer() {
		Customer dummyCustomer = new Customer();

		dummyCustomer.setUniqueId("A00001");
		dummyCustomer.setFirstName("James");
		dummyCustomer.setLastName("Smith");
		dummyCustomer.setAccountNumber("0000111100001111");
		dummyCustomer.setFavoriteColor("Green");

		return dummyCustomer;
	}
}
