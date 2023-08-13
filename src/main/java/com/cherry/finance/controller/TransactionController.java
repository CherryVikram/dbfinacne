package com.cherry.finance.controller;

import com.cherry.finance.model.Transaction;
import com.cherry.finance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        HttpHeaders  headers = new HttpHeaders();
        headers.set("Allow-Control-Allow-Origin", "*");
        return new ResponseEntity<>(transactionService.createTransaction(transaction), headers, HttpStatus.CREATED);
    }
}
