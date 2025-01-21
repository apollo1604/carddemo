package com.mechanizedai.carddemo.service;

import com.mechanizedai.carddemo.models.Transaction;
import com.mechanizedai.carddemo.repositories.TransactionRepository;
import com.mechanizedai.carddemo.services.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void shouldReturnTransactionById() {
        // Arrange
        Transaction transaction = new Transaction(1L, "12345", "987654321", BigDecimal.valueOf(100.00));
        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));

        // Act
        Transaction result = transactionService.getTransactionById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("12345", result.getAccountId());
        verify(transactionRepository, times(1)).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenTransactionNotFound() {
        // Arrange
        when(transactionRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> transactionService.getTransactionById(1L));
    }
}
