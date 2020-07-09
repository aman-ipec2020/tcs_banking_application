package com.tcs.project.sash.services;

import java.util.Date;
import java.util.List;

import com.tcs.project.sash.model.Transaction;

public interface TransactionServiceInterface
{
	public boolean addTransaction(Transaction tx);
	public List<Transaction> getAllTransaction();
	public List<Transaction> getTransactioninRangeFromLast(int number);
	public List<Transaction> getTransactioninRangeFromBegin(int number);
	public List<Transaction> getTransactionInRangeForOneCustomer(String account_id, Date from, Date to);
	public List<Transaction> getTransactionInRangeForAllCustomer(Date from, Date to);
}
