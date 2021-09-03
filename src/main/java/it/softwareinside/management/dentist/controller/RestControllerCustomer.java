package it.softwareinside.management.dentist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.softwareinside.management.dentist.model.Customer;
import it.softwareinside.management.dentist.service.CustomerService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class RestControllerCustomer {

	@Autowired
	private CustomerService customerService;
	
	/**
	 * uri to get all customer
	 * @return
	 */
	@GetMapping("/getAll")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}
	/**
	 * uri to get one appointment by ID
	 * @return
	 */
	@GetMapping(value = "/getOneCustomer/{cf}")
	public Customer getOneCustomer(@PathVariable String cf) {
		return customerService.getOneCustomer(cf);
	}
	/**
	 * uri to insert Customer
	 * @param customer
	 * @return
	 */
	@PostMapping(value="/insert")
    public boolean insertCustomer(@RequestBody()Customer customer) {
        return customerService.insertCustomer(customer);
    }
	
	@PutMapping(value="/edit/{cf}")
	public boolean editCustomer(@PathVariable() String cf,@RequestBody() Customer customer) {
		return customerService.editCustomer(cf, customer);
	}
	
	@DeleteMapping("/delete/{cf}")
    public boolean deleteCustomer(@PathVariable String cf) {
        return customerService.deleteCustomer(cf);
    }
	
}
