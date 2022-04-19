package com.player.repository;

import com.player.model.FinancialStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialStatementRepository extends JpaRepository<FinancialStatement, Integer> {
}
