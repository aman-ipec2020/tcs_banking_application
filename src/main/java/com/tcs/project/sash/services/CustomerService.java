package com.tcs.project.sash.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.project.sash.model.Customer;
import com.tcs.project.sash.repository.CustomerRepository;


@Service
public class CustomerService implements CustomerServiceInterface
{
	@Autowired
	private CustomerRepository customerRepo;	
	
	@Override
	public String addNewCustomer(Customer customer)
	{
		if(customerRepo.existsById(customer.getCustomer_id()))
		{
			System.out.println("customers with ID : " + customer.getCustomer_id() + " Already Exists!!!");
			return "Customer with ID Already Exists...!!!";
		}
		else
		{
			customerRepo.save(customer);
			System.out.println("customers with ID : " + customer.getCustomer_id() + " ADDED Successfully!!!");
			return "new Customer Added Successfully...";
		}
	}
	
	public Customer addCustomer(Customer customer)
	{
		if(customerRepo.existsById(customer.getCustomer_id()))
		{
			System.out.println("customers with ID : " + customer.getCustomer_id() + " Already Exists!!!");
			return new Customer();
		}
		else
		{
			customerRepo.save(customer);
			System.out.println("customers with ID : " + customer.getCustomer_id() + " ADDED Successfully!!!");
			return customerRepo.getOne(customer.getCustomer_id());
		}
	}

	@Override
	public Customer getCustomerByID(String id)
	{
		if(customerRepo.existsById(id))
		{
			System.out.println("customers with ID : " + id + " FOUND...");
			Customer customer = customerRepo.getOne(id);
			
			return customer;
		}
		
		System.out.println("customers with ID : " + id + " NOT FOUND!!!");
		return new Customer();
	}
	
	@Override
	public List<Customer> getCustomerByName(String name)
	{
		List<Customer> list = new ArrayList<>();

		for(Customer obj : customerRepo.findAll())
			if(obj.getCustomer_name().equalsIgnoreCase(name))
				list.add(obj);
		
		return list;
	}

	@Override
	public List<Customer> getAllCustomers()
	{
		System.out.println("Total Count of customers : " + customerRepo.count());
		return customerRepo.findAll();
	}

	@Override
	public String deleteCustomerByID(String id)
	{
		if(customerRepo.existsById(id))
		{
			System.out.println("customers with ID : " + id + " FOUND...");
			
//				for(Transaction obj: txRepo.findByCustomerId(id))
//					txRepo.deleteById(obj.getcustomerId());

				customerRepo.deleteById(id);

			return "customers with ID : " + id + " DELETED SUCCESSFULLY...";			
		}
		
		return "customers with ID : " + id + " NOT FOUND!!!";
	}


	@Override
	public String updateCustomer(Customer obj)
	{	
		if(obj != null)
		{
			customerRepo.save(obj);	
			return "Customer with ID : " + obj.getCustomer_id()+ " successfully updated..!!!";
		}

		return "failed to update..!!!";
	}
}
