package org.example.currencylimitmanager.controller;

import org.example.currencylimitmanager.model.MonthlyLimit;
import org.example.currencylimitmanager.model.Transaction;
import org.example.currencylimitmanager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.save(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/exceeded-limit")
    public ResponseEntity<List<Transaction>> getTransactionsExceedingLimit(@RequestParam Long monthlyLimitId) {
        MonthlyLimit monthlyLimit = new MonthlyLimit();
        List<Transaction> transactions = transactionService.getAllTransactionsExceedingLimit(monthlyLimit);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
