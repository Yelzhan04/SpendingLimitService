package org.example.currencylimitmanager.repository;

import org.example.currencylimitmanager.model.MonthlyLimit;
import org.example.currencylimitmanager.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findAll();

    List<Transaction> findByMonthlyLimitAndLimitExceededIsTrue(MonthlyLimit monthlyLimit);

    BigDecimal sumAmountByMonthlyLimit(MonthlyLimit monthlyLimit);

    List<Transaction> findByTransactionDateBetween(Date startDate, Date endDate);

    List<Transaction> findByExpenseCategory(String expenseCategory);

}
