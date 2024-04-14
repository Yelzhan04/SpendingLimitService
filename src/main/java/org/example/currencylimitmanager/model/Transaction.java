package org.example.currencylimitmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "account_from")
    private Long accountFrom;

    @Column(name = "account_to")
    private Long accountTo;

    @Column(name = "currency_shortname")
    private String currencyShortname;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "expense_category")
    private String expenseCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "limit_id", referencedColumnName = "id")
    private MonthlyLimit monthlyLimit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exchange_rate_id",referencedColumnName = "id")
    private ExchangeRate exchangeRate;

    @Column(name = "limit_exceeded")
    private boolean limitExceeded;
}
