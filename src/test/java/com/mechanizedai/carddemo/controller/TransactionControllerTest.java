package com.mechanizedai.carddemo.controller;

import com.mechanizedai.carddemo.controllers.TransactionController;
import com.mechanizedai.carddemo.models.Transaction;
import com.mechanizedai.carddemo.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionControllerTest {

    private TransactionController transactionController;

    @Mock
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
        transactionController = new TransactionController(transactionService);
    }

    @Test
    void testGetTransactionById_Success() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1L);
        transaction.setAccountId("ACC123");

        when(transactionService.getTransactionById(1L)).thenReturn(transaction);

        // Act
        ResponseEntity<Transaction> response = transactionController.getTransactionById(1L);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getTransactionId());
        verify(transactionService, times(1)).getTransactionById(1L);
    }



    @Test
    void testDeleteTransaction() {
        // Arrange
        Long transactionId = 1L;
        doNothing().when(transactionService).deleteTransaction(transactionId);

        // Act
        ResponseEntity<Void> response = transactionController.deleteTransaction(transactionId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(transactionService, times(1)).deleteTransaction(transactionId);
    }

}
