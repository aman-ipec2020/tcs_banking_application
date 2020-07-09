package com.tcs.project.sash.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.project.sash.model.Transaction;
import com.tcs.project.sash.services.TransactionService;

@Controller
@RequestMapping("sash")
public class TransactionController
{
	@Autowired
	private TransactionService txService;

	@RequestMapping("banking/transaction/all")
	public ModelAndView displayAllTransaction()
	{
		ModelAndView mv = new ModelAndView("banking/transactions");
		mv.addObject("tx", txService.getAllTransaction());
		
		return mv;
	}
	
	@RequestMapping("banking/transaction/search")
	public ModelAndView searchTransaction()
	{
		ModelAndView mv = new ModelAndView("banking/search_transactions");		
		return mv;
	}
	
	//	Process View Statement Request for One Accounts
	@RequestMapping("banking/transaction/statement/id")
	public ModelAndView transactionInRangeForOneAccount(HttpServletRequest request)
	{
		String id = request.getParameter("id");

		Date from = new Date();

		try {	
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			from = format.parse(request.getParameter("from"));
		} catch (ParseException e) {	e.printStackTrace();	}

		Date to = new Date();

		try {	
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			to = format.parse(request.getParameter("to"));
		} catch (ParseException e) {	e.printStackTrace();	}
		
		
		if(id == null || from == null || to == null)
		{
			ModelAndView mv = new ModelAndView("banking/search_transactions");
			mv.addObject("alert", "Invalied Input Data");
			return mv;
		}
		else
		{
			List<Transaction> list = txService.getTransactionInRangeForOneCustomer(id, from, to);
			
			if(list != null)
			{
				ModelAndView mv = new ModelAndView("banking/transactions");
				mv.addObject("tx", list);
				mv.addObject("alert", "All Date Fetched Successfully");
				return mv;
			}
			else
			{
				ModelAndView mv = new ModelAndView("banking/transactions");
				mv.addObject("alert", "No Data Available..!!!");
				return mv;
			}			
		}
	}
	
	//	Process View Statement Request for All Accounts
	@RequestMapping("banking/transaction/statement/all")
	public ModelAndView transactionInRangeForAllAccounts(HttpServletRequest request)
	{
		Date from = new Date();
		try {	
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			from = format.parse(request.getParameter("from"));
		} catch (ParseException e) {	e.printStackTrace();	}

		Date to = new Date();

		try {	
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			to = format.parse(request.getParameter("to"));
		} catch (ParseException e) {	e.printStackTrace();	}
		
		
		if(from == null || to == null)
		{
			ModelAndView mv = new ModelAndView("banking/search_transactions");
			mv.addObject("alert", "Invalied Input Data");
			return mv;
		}
		else
		{
			List<Transaction> list = txService.getTransactionInRangeForAllCustomer(from, to);
			
			if(list != null)
			{
				ModelAndView mv = new ModelAndView("banking/transactions");
				mv.addObject("tx", list);
				mv.addObject("alert", "All Date Fetched Successfully");
				return mv;
			}
			else
			{
				ModelAndView mv = new ModelAndView("banking/transactions");
				mv.addObject("alert", "No Data Available..!!!");
				return mv;
			}			
		}		
	}
}
