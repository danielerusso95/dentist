package it.softwareinside.management.dentist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareinside.management.dentist.model.Customer;
import it.softwareinside.management.dentist.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * return full list of customer
	 * @return
	 */
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	/**
	 * return one customer by ID
	 * @return
	 */
	public Customer getOneCustomer(String cf) {
		return customerRepository.findById(cf).get();
	}

	/**
	 * return true if customer is added, if not return false
	 * @param c
	 * @return
	 */
	public boolean insertCustomer(Customer c) {
		for(int i=0;i<customerRepository.findAll().size();i++) {
			if(customerRepository.findAll().get(i).equals(c))
				return false;
		}
		customerRepository.save(c);
		return true;
	}

	public Customer editCustomer(String cf,Customer newCustomer) {
			Customer customer = customerRepository.findById(cf).get();
			customer.setCf(newCustomer.getCf());
	        customer.setName(newCustomer.getName());
	        customer.setSurname(newCustomer.getSurname());
	        customer.setEmail(newCustomer.getEmail());
	        customer.setPhoneNumber(newCustomer.getPhoneNumber());
	        customerRepository.save(customer);
	        return customer;
	}

	public boolean deleteCustomer(String cf) {
		for (int i = 0; i<customerRepository.findAll().size(); i++) {
			if(customerRepository.findAll().get(i).getCf().equals(cf)) {
				customerRepository.deleteById(cf);
				return true;
			}
		}
		return false;
	}
}
