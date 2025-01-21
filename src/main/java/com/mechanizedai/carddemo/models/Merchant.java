package com.mechanizedai.carddemo.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "merchants")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "merchant_name", nullable = false, length = 100)
    private String merchantName;

    @Column(name = "merchant_city", nullable = false, length = 50)
    private String merchantCity;

    @Column(name = "merchant_zip", nullable = false, length = 10)
    private String merchantZip;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantName(String testMerchant) {
        this.merchantName = testMerchant;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantCity(String testCity) {
        this.merchantCity = testCity;
    }

    public void setMerchantZip(String number) {
        this.merchantZip = number;
    }

    public void setMerchantId(long l) {
        this.merchantId = l;
    }

    // Getters y Setters
}
