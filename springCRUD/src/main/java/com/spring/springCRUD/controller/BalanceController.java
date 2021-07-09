package com.spring.springCRUD.controller;

import com.spring.springCRUD.controller.request.BalanceRequest;
import com.spring.springCRUD.entity.Balance;
import com.spring.springCRUD.service.BalanceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/balances")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService service;

    @GetMapping
    public ResponseEntity<List<Balance>> getAllBalance() {
        List<Balance> balanceList = service.getAllBalance();
        return new ResponseEntity<>(balanceList, HttpStatus.OK);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Balance> getBalanceWithId(@PathVariable("uid") String uid) {
        Balance balances = service.getBalanceWithId(uid);
        return new ResponseEntity<>(balances, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Balance> createBalance(@Valid @RequestBody BalanceRequest balanceRequest) {
        Balance balance = service.createBalance(balanceRequest);
        return new ResponseEntity<>(balance, HttpStatus.CREATED);
    }

    @PutMapping("/{uid}")
    public ResponseEntity<Balance> updateBalance(@PathVariable("uid") String uid, @Valid @RequestBody Balance balance) {
        Balance balanceData = service.updateBalance(uid, balance);
        return new ResponseEntity<>(balanceData, HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Balance> deleteBalance(@PathVariable("uid") String uid) {
        Balance balance = service.deleteBalance(uid);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
}