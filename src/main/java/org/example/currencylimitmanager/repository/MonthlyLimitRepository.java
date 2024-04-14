package org.example.currencylimitmanager.repository;

import org.example.currencylimitmanager.model.MonthlyLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyLimitRepository extends JpaRepository<MonthlyLimit,Long> {
}
