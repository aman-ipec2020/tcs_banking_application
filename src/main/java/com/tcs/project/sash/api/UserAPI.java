package com.tcs.project.sash.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.project.sash.model.Customer;
import com.tcs.project.sash.model.User;
import com.tcs.project.sash.model.UserType;
import com.tcs.project.sash.repository.UserRepository;
import com.tcs.project.sash.services.CustomerService;

@RestController
@RequestMapping("sash/customers")
public class UserAPI
{
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserRepository users;
	
	@GetMapping("customer/id/{id}")
	public ResponseEntity<Customer> displayCustomerByID(@PathVariable("id") String id)
	{
		Customer obj = customerService.getCustomerByID(id);
		if(obj != null)
			return new ResponseEntity<Customer> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<Customer> (new Customer(), HttpStatus.OK);
	}
	
	@GetMapping("customer/name/{name}")
	public ResponseEntity<List<Customer>> displayCustomerByName(@PathVariable("name") String name)
	{
		List<Customer> obj = customerService.getCustomerByName(name);
		
		if(obj != null)
			return new ResponseEntity<List<Customer>> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<List<Customer>> (new ArrayList<Customer>(), HttpStatus.OK);
	}
	
	@PostMapping("customer")
	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer)	
	{
		Customer obj = customerService.addCustomer(customer);
		if(obj != null)
			return new ResponseEntity<Customer>(obj, HttpStatus.OK);
		else
			return new ResponseEntity<Customer>(new Customer(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("customer")
	public ResponseEntity<List<Customer>> displayAllCustomers()	
	{
		List<Customer> list = customerService.getAllCustomers();
		if(list != null)
			return new ResponseEntity<List<Customer>> (list, HttpStatus.OK);
		else
			return new ResponseEntity<List<Customer>> (new ArrayList<>(), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("users")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> list = users.findAll();
		if(list != null)
			return new ResponseEntity<List<User>> (list, HttpStatus.OK);
		else
			return new ResponseEntity<List<User>> (new ArrayList<>(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("user")
	public ResponseEntity<User> createUser()
	{
		return new ResponseEntity<User> (new User().setUsername("aman").setPassword("tcs").setType(UserType.cashier), HttpStatus.OK);
	}
	
	@PostMapping("users/add")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		if(user != null)
		{
			users.save(user);
			return new ResponseEntity<User> (user, HttpStatus.OK);
		}
		else
			return new ResponseEntity<User> (new User(), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id)
	{
		if(id != null)
		{
			User user = users.getOne(Long.parseLong(id));
			
			if(user != null)
				return new ResponseEntity<User> (user, HttpStatus.OK);
			else
				return new ResponseEntity<User> (new User(), HttpStatus.NOT_FOUND);
		}
		else
			return new ResponseEntity<User> (new User(), HttpStatus.NOT_FOUND);
	}
}
