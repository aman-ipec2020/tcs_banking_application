package com.tcs.project.sash.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.project.sash.model.Transaction;
import com.tcs.project.sash.repository.TransactionRepository;

@Service
public class TransactionService implements TransactionServiceInterface
{
	@Autowired
	private TransactionRepository txRepo;
	
	@Override
	public boolean addTransaction(Transaction tx)
	{
		if(tx != null)
		{	
			txRepo.save(tx);
			return true;
		}

		return false;
	}
	
	@Override
	public List<Transaction> getAllTransaction()
	{
		List<Transaction> list = txRepo.findAll();
		
		if(list != null)
			return list;

		return new ArrayList<>();
	}
	
	@Override
	public List<Transaction> getTransactioninRangeFromLast(int number)
	{
		List<Transaction> list = txRepo.findAll();
		
		if(list != null)
			return list;

		return new ArrayList<>();
	}
	
	@Override
	public List<Transaction> getTransactioninRangeFromBegin(int number)
	{
		List<Transaction> list = txRepo.findAll();
		
		if(list != null)
			return list;

		return new ArrayList<>();
	}

	@Override
	public List<Transaction> getTransactionInRangeForOneCustomer(String id, Date from, Date to)
	{
		List<Transaction> list = txRepo.findTranscationByDateRangeAndAccountID(id, from, to);
			
		if(list != null)
			return list;
		else
			return new ArrayList<>();
	}
	
	@Override
	public List<Transaction> getTransactionInRangeForAllCustomer(Date from, Date to)
	{
		List<Transaction> list = txRepo.findTranscationByDateRange(from, to);
			
		if(list != null)
			return list;
		else
			return new ArrayList<>();
	}
}
