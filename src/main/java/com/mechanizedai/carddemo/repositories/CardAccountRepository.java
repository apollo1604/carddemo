package com.mechanizedai.carddemo.repositories;

import com.mechanizedai.carddemo.models.CardAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardAccountRepository extends JpaRepository<CardAccount, Long> {
    CardAccount findByAccountIdAndCardNumber(String accountId, String cardNumber);
}

