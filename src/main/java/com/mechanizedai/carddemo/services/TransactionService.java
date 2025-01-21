package com.mechanizedai.carddemo.services;

import com.mechanizedai.carddemo.models.CardAccount;
import com.mechanizedai.carddemo.models.Transaction;
import com.mechanizedai.carddemo.repositories.CardAccountRepository;
import com.mechanizedai.carddemo.repositories.MerchantRepository;
import com.mechanizedai.carddemo.repositories.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final MerchantRepository merchantRepository;
    private final CardAccountRepository cardAccountRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              MerchantRepository merchantRepository,
                              CardAccountRepository cardAccountRepository) {
        this.transactionRepository = transactionRepository;
        this.merchantRepository = merchantRepository;
        this.cardAccountRepository = cardAccountRepository;
    }

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        // Validar merchant
        if (!merchantRepository.existsById(transaction.getMerchant().getMerchantId())) {
            throw new IllegalArgumentException("Merchant not found.");
        }

        // Validar cuenta y tarjeta
        CardAccount account = cardAccountRepository.findByAccountIdAndCardNumber(
                transaction.getAccountId(), transaction.getCardNumber()
        );

        if (account == null) {
            throw new IllegalArgumentException("Invalid account or card number.");
        }

        // Guardar transacción
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found."));
    }

    @Transactional
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Transaction existingTransaction = getTransactionById(id);
        existingTransaction.setTransactionAmount(updatedTransaction.getTransactionAmount());
        existingTransaction.setTransactionDescription(updatedTransaction.getTransactionDescription());
        existingTransaction.setProcessingDate(updatedTransaction.getProcessingDate());
        existingTransaction.setOriginalDate(updatedTransaction.getOriginalDate());
        return transactionRepository.save(existingTransaction);
    }

    @Transactional
    public void deleteTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new IllegalArgumentException("Transaction not found.");
        }
        transactionRepository.deleteById(id);
    }
}
