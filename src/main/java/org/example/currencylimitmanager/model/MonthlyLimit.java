package org.example.currencylimitmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "monthly_limits")
@Getter
@Setter
public class MonthlyLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "limit_usd")
    private BigDecimal limitUSD;

}
