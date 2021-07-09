package com.spring.springCRUD.repository;

import com.spring.springCRUD.entity.Balance;
import com.spring.springCRUD.entity.Employee;
import com.spring.springCRUD.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, String> {

}
