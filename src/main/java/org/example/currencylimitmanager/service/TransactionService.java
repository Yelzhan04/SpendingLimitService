package org.example.currencylimitmanager.service;

import org.example.currencylimitmanager.model.MonthlyLimit;
import org.example.currencylimitmanager.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction save(Transaction transaction);

    List<Transaction> getAllTransactions();

    List<Transaction> getAllTransactionsExceedingLimit(MonthlyLimit monthlyLimit);
}
