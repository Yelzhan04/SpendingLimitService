package org.example.currencylimitmanager.service.impl;

import org.example.currencylimitmanager.model.MonthlyLimit;
import org.example.currencylimitmanager.model.Transaction;
import org.example.currencylimitmanager.repository.TransactionRepository;
import org.example.currencylimitmanager.service.TransactionService;
import org.example.currencylimitmanager.utils.exceptions.TransactionServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        if (transaction == null) {
            throw new TransactionServiceException("Transaction cannot be null");
        }
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getAllTransactionsExceedingLimit(MonthlyLimit monthlyLimit) {
        if (monthlyLimit == null) {
            throw new IllegalArgumentException("Monthly limit cannot be null");
        }
        return transactionRepository.findByMonthlyLimitAndLimitExceededIsTrue(monthlyLimit);
    }
}
