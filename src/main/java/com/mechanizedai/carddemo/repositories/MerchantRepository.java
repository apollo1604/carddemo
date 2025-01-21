package com.mechanizedai.carddemo.repositories;

import com.mechanizedai.carddemo.models.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
