package com.mechanizedai.carddemo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "card_accounts")
public class CardAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relation_id")
    private Long relationId;

    @Column(name = "account_id", nullable = false, length = 11)
    private String accountId;

    @Column(name = "card_number", nullable = false, length = 16)
    private String cardNumber;

    public void setAccountId(String number) {
        this.accountId = number;
    }

    public void setCardNumber(String number) {
        this.cardNumber = number;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Long getAccountId() {
        return relationId;
    }

    // Getters y Setters
}
