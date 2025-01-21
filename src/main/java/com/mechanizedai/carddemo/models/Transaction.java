package com.mechanizedai.carddemo.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "card_number", nullable = false, length = 16)
    private String cardNumber;

    @Column(name = "account_id", nullable = false, length = 11)
    private String accountId;

    @Column(name = "transaction_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal transactionAmount;

    @Column(name = "transaction_type_code", nullable = false, length = 4)
    private String transactionTypeCode;

    @Column(name = "transaction_category_code", nullable = false, length = 4)
    private String transactionCategoryCode;

    @Column(name = "transaction_source", nullable = false, length = 50)
    private String transactionSource;

    @Column(name = "transaction_description", nullable = false, length = 255)
    private String transactionDescription;

    @Column(name = "original_date", nullable = false)
    private LocalDate originalDate;

    @Column(name = "processing_date", nullable = false)
    private LocalDate processingDate;

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    public Transaction(long transactionId, String accountId, String cardNumber, BigDecimal transactionAmount) {
        this.transactionId = transactionId;
        this.cardNumber = cardNumber;
        this.accountId = accountId;
        this.transactionAmount = transactionAmount;
    }

    public Transaction() {

    }

    // Getters y Setters

    public Merchant getMerchant() {
        return merchant;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setProcessingDate(LocalDate processingDate) {
        this.processingDate = processingDate;
    }

    public LocalDate getProcessingDate() {
        return processingDate;
    }

    public void setOriginalDate(LocalDate originalDate) {
        this.originalDate = originalDate;
    }

    public LocalDate getOriginalDate() {
        return originalDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setTransactionCategoryCode(String number) {
        this.transactionCategoryCode = number;
    }

    public void setTransactionSource(String testSource) {
        this.transactionSource = testSource;
    }

    public void setTransactionTypeCode(String number) {
        this.transactionTypeCode = number;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public void setTransactionId(long l) {
        this.transactionId = l;
    }
}

