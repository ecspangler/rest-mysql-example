package org.example.repository;

import java.math.BigInteger;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Customer;
import org.example.repository.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MySqlCustomerRepository implements CustomerRepository {

	private static final Logger log = LogManager.getLogger(MySqlCustomerRepository.class);

	HibernateUtil hibernateUtil = new HibernateUtil();

	final Session session = hibernateUtil.getHibernateSession();

	@Override
	public void addCustomer(Customer customer) {
		// In a real application the full object would not be logged at info level
		log.info("Saving customer: {}", customer);

		Transaction transaction = session.beginTransaction();
		session.save(customer);

		transaction.commit();
	}

	@Override
	public List<Customer> getAllCustomers() {
		Transaction transaction = session.beginTransaction();

		Criteria cr = session.createCriteria(Customer.class);
		List<Customer> results = cr.list();

		transaction.commit();

		return results;
	}

	@Override
	public Customer getCustomer(BigInteger id) {
		log.info("Retrieving customer with id: {}", id);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
	}

	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public Session getSession() {
		return session;
	}

}
