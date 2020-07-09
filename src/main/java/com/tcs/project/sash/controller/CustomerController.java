package com.tcs.project.sash.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.project.sash.model.AccountType;
import com.tcs.project.sash.model.Address;
import com.tcs.project.sash.model.Customer;
import com.tcs.project.sash.model.CustomerOperation;
import com.tcs.project.sash.repository.AddressRepository;
import com.tcs.project.sash.services.AccountService;
import com.tcs.project.sash.services.CustomerService;

@Controller
@RequestMapping("sash")
public class CustomerController
{
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private AccountService accountServices;
	
	private Customer customer = new Customer();
	private ModelAndView model = new ModelAndView();
	
	@RequestMapping("customer")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("customer/home");
		return mv;
	}

/***********************************************|CARETE NEW CUSTOMER [completed]	|**********************************************************/

	@RequestMapping("customer/create")
	public ModelAndView add()
	{
		ModelAndView mv = new ModelAndView("customer/create_customer");

		return mv;
	}

	@RequestMapping("customer/create/id")
	public String addCustomer(HttpServletRequest request)
	{		
		Date dob = new Date();

		try {	
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			dob = format.parse(request.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("customer/home");
		Customer obj = new Customer();
		
		obj.setCustomer_id("U-00" + (customerService.getAllCustomers().size() + 1))
			.setCustomer_name(request.getParameter("customer_name"))
			.setAadhar_no(request.getParameter("aadhar_no"))
			.setCustomer_contact1(request.getParameter("contact1"))
			.setCustomer_contact2(request.getParameter("contact2"))
			.setCustomer_email(request.getParameter("email"))
			.setAge(new Date().getYear() - dob.getYear())
			.setDob(dob)
			.setAddress(new Address().setAddress_id("A-10" + (addressRepo.count() + 1))
									.setPlot(request.getParameter("plot"))
									.setArea(request.getParameter("area"))
									.setDistrict(request.getParameter("district"))
									.setState(request.getParameter("state"))
									.setPincode(Integer.parseInt(request.getParameter("pincode"))))
			.setDoc(new Date())
			.setLast_operation(CustomerOperation.created)
			.setLast_updated(new Date())
			.setMessage(request.getParameter("message"));

		
		mv.addObject("alert", customerService.addCustomer(obj));

		model.addObject("customer", "");
		model.addObject("account", "");
		
		return "redirect:";
	}

/*******************************************|	CARETE NEW ACCOUNT [completed]	|**************************************************************/
	
	@RequestMapping("banking/account/create")
	public ModelAndView create()
	{
		ModelAndView mv = new ModelAndView("banking/create_account");
		mv.addObject("id", model.getModel().get("customer_id").toString());
		return mv;
	}
	
	@RequestMapping("banking/account/create/id")
	public ModelAndView newAccount(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("banking/home");
		
		if(request.getParameter("type").equalsIgnoreCase("SAVINGS"))
		{
			model.addObject("alert", accountServices.addNewAccount(customerService.getCustomerByID(model.getModel().get("customer_id").toString()), 
																			AccountType.saving,
																			Double.parseDouble(request.getParameter("amount")),
																			request.getParameter("message")));
			return mv;
		}
		if(request.getParameter("type").equalsIgnoreCase("CURRENT"))
		{
			model.addObject("alert", accountServices.addNewAccount(customerService.getCustomerByID(model.getModel().get("customer_id").toString()), 
																			AccountType.current,
																			Double.parseDouble(request.getParameter("amount")),
																			request.getParameter("message")));
			return mv;
		}
			return mv;
	}	
	
/******************************************|	SEARCH	[COMPLETED]	|***************************************************************/

	@RequestMapping("customer/search")
	public ModelAndView searchCustomer()
	{
		ModelAndView mv = new ModelAndView("customer/search");
		return mv;
	}
	
	@RequestMapping("customer/search/id")
	public ModelAndView displayCustomerInfo(@RequestParam("id") String id)
	{
		if(id != null)
		{
			customer = customerService.getCustomerByID(id);
			
			if(customer.getCustomer_id() != null)
			{
				ModelAndView mv = new ModelAndView("customer/customer");
				mv.addObject("customer", customer);
				
				return mv;
			}
			
			ModelAndView mv = new ModelAndView("customer/search");
			mv.addObject("alert", "Account ID is Invalied or Account is not avaiable...!!");
			return mv;
		}
		
		ModelAndView mv = new ModelAndView("customer/search");
		mv.addObject("alert", "Invailed Customer ID");
		return mv;
	}
	
//			SEARCH-ALL Customers
	@RequestMapping("customer/search/all")
	public ModelAndView searchAllCustomer()
	{
		ModelAndView mv = new ModelAndView("customer/customers");
		mv.addObject("customer", customerService.getAllCustomers());
		return mv;
	}
	
/*********************************************************************************************************/
	
	//	create session of Customer Data and it's Account Data
	@RequestMapping("customer/update")
	public ModelAndView update()
	{
		ModelAndView mv = new ModelAndView("customer/search_update");
		return mv;
	}

//	create session of Customer Data and it's Account Data
	@RequestMapping("customer/update/search/id2")
	public ModelAndView updateFromSearch()
	{
			customer = customerService.getCustomerByID(customer.getCustomer_id());
			
			if(customer != null)
			{
				ModelAndView mv = new ModelAndView("customer/update");			
				mv.addObject("customer", customer);
				return mv;
			}
			
			ModelAndView mv = new ModelAndView("customer/search_update");			
			mv.addObject("alert", "Give proper Customer ID");
			return mv;
		
	}
	
	//	create session of Customer Data and it's Account Data
	@RequestMapping("customer/update/search")
	public ModelAndView update(@RequestParam("id") String id)
	{	
		if(id != null)
		{
			customer = customerService.getCustomerByID(id);
			
			if(customer != null)
			{
				ModelAndView mv = new ModelAndView("customer/update");			
				mv.addObject("customer", customer);
				return mv;
			}
			
			ModelAndView mv = new ModelAndView("customer/search_update");			
			return mv;
			
			
		}
		
		ModelAndView mv = new ModelAndView("customer/search");
		mv.addObject("alert", "Give proper Customer ID");
		return mv;
		
	}
	
	//	Update data and show all Data
	@RequestMapping("customer/update/search/id")
	public ModelAndView processUpdateRequest(HttpServletRequest request)
	{
		if(request != null)
		{
			Date dob = new Date();
			
			try {	
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				dob = format.parse(request.getParameter("dob"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Customer customer = customerService.getCustomerByID(this.customer.getCustomer_id());
			Address address = addressRepo.getOne(this.customer.getAddress().getAddress_id());
			
			customer.setCustomer_name(request.getParameter("customer_name"))
					.setCustomer_contact1(request.getParameter("contact1"))
					.setCustomer_contact2(request.getParameter("contact2"))
					.setCustomer_email(request.getParameter("email"))
					.setAge(new Date().getYear() - dob.getYear()).setDob(dob)
					.setAddress(address.setPlot(request.getParameter("plot"))
										.setArea(request.getParameter("area"))
										.setDistrict(request.getParameter("district"))
										.setState(request.getParameter("state"))
										.setPincode(Integer.parseInt(request.getParameter("pincode"))))
					.setLast_operation(CustomerOperation.updated)
					.setLast_updated(new Date())
					.setMessage(request.getParameter("message"));			
			
			
			ModelAndView mv = new ModelAndView("customer/search_update");
			mv.addObject("alert", customerService.updateCustomer(customer));
			
			return mv;
		}
		
			ModelAndView mv = new ModelAndView("customer/search_update");
			mv.addObject("alert", "Give proper Customer ID");
			
			return mv;
		
		
		
	}
	
/*********************************************************************************************************/
	
//	create session of Customer Data and it's Account Data
	@RequestMapping("customer/delete")
	public ModelAndView delete()
	{
		ModelAndView mv = new ModelAndView("customer/search_delete");
		return mv;
	}

	@RequestMapping("customer/delete/search/")
	public ModelAndView deleteCustomer(@RequestParam("id") String id)
	{
		if(id != null)
		{
			customer = customerService.getCustomerByID(id);
			
			if(customer != null)
			{
				ModelAndView mv = new ModelAndView("customer/delete");
				mv.addObject("customer", customer);
				mv.addObject("alert", customerService.deleteCustomerByID(id));
				return mv;
			}
			
			ModelAndView mv = new ModelAndView("customer/search_delete");
			mv.addObject("alert", "Invalied Customer ID");
			return mv;
			
		}
		
			ModelAndView mv = new ModelAndView("customer/search_delete");
			mv.addObject("alert", "Give Valid Customer ID");
			
			return mv;
	}
	
	@RequestMapping("customer/delete/search/id")
	public ModelAndView processDeleteRequest()
	{
		ModelAndView mv = new ModelAndView("customer/search_delete");
		mv.addObject("customer", customer);
		mv.addObject("alert", customerService.deleteCustomerByID(customer.getCustomer_id()));
		customer = null;
		
		return mv;
	}
}