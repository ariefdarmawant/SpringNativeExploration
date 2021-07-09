package com.spring.springCRUD.service;

import com.spring.springCRUD.controller.request.BalanceRequest;
import com.spring.springCRUD.entity.Balance;
import com.spring.springCRUD.exception.DataNotFoundException;
import com.spring.springCRUD.repository.BalanceRepository;
import com.spring.springCRUD.repository.EmployeeRepository;
import com.spring.springCRUD.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final EmployeeRepository employeeRepository;

    private final ItemRepository itemRepository;

    private final BalanceRepository balanceRepository;

    public List<Balance> getAllBalance() {
        return balanceRepository.findAll();
    }

    public Balance getBalanceWithId(String uid) {
        Optional<Balance> balance = balanceRepository.findById(uid);
        return balance.orElseThrow(() -> new DataNotFoundException(Balance.class, "Balance with uid : " + uid + " not found."));
    }

    public Balance createBalance(BalanceRequest balanceRequest) {
        return balanceRepository.save(balanceRequest.toEntity(employeeRepository.getById(balanceRequest.getEmpUid()), itemRepository.getById(balanceRequest.getItemUid())));
    }

    public Balance updateBalance(String uid, Balance balance){
        Optional<Balance> balanceData = balanceRepository.findById(uid);
        Balance saveBalance = balanceData.orElseThrow(() -> new DataNotFoundException(Balance.class, "Balance with uid : " + uid + " not found."));
        saveBalance.setAmount(balance.getAmount());
        saveBalance.setSpentAmount(balance.getSpentAmount());
        return balanceRepository.save(saveBalance);
    }

    public Balance deleteBalance(String uid){
        Optional<Balance> balance = balanceRepository.findById(uid);
        balanceRepository.deleteById(uid);
        return balance.orElseThrow(() -> new DataNotFoundException(Balance.class, "Balance with uid : " + uid + " not found."));
    }
}
