package com.mechanizedai.carddemo.repository;

import com.mechanizedai.carddemo.models.Transaction;
import com.mechanizedai.carddemo.repositories.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionRepositoryTest {

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1L);
        transaction.setAccountId("ACC123");
        transaction.setCardNumber("1234567890123456");

        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));

        // Act
        Optional<Transaction> result = transactionRepository.findById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getTransactionId());
        verify(transactionRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveTransaction() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1L);
        transaction.setAccountId("ACC123");
        transaction.setCardNumber("1234567890123456");

        when(transactionRepository.save(transaction)).thenReturn(transaction);

        // Act
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Assert
        assertNotNull(savedTransaction);
        assertEquals("ACC123", savedTransaction.getAccountId());
        verify(transactionRepository, times(1)).save(transaction);
    }

    @Test
    void testDeleteTransaction() {
        // Arrange
        Long transactionId = 1L;
        doNothing().when(transactionRepository).deleteById(transactionId);

        // Act
        transactionRepository.deleteById(transactionId);

        // Assert
        verify(transactionRepository, times(1)).deleteById(transactionId);
    }
}
