package com.mechanizedai.carddemo.repositories;

import com.mechanizedai.carddemo.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
