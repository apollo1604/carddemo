package com.mechanizedai.carddemo.services;

import com.mechanizedai.carddemo.models.Merchant;
import com.mechanizedai.carddemo.repositories.MerchantRepository;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public Merchant getMerchantById(Long id) {
        return merchantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Merchant not found."));
    }

}
