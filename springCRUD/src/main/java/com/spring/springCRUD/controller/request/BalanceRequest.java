package com.spring.springCRUD.controller.request;

import com.spring.springCRUD.entity.Balance;
import com.spring.springCRUD.entity.Employee;
import com.spring.springCRUD.entity.Item;
import com.spring.springCRUD.repository.EmployeeRepository;
import com.spring.springCRUD.repository.ItemRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceRequest {

    @NotNull(message = "Employee uid cannot be null.")
    private String empUid;

    @NotNull(message = "Item uid cannot be null.")
    private String itemUid;

    @Size(min = 0, message = "Amount cannot be negative.")
    private int amount;

    @Size(min = 0, message = "Spent amount cannot be negative.")
    private int spentAmount;

    public Balance toEntity(Employee employee, Item item) {
        Balance balance = new Balance();
        balance.setEmployee(employee);
        balance.setItem(item);
        balance.setAmount(this.amount);
        balance.setSpentAmount(this.spentAmount);
        return balance;
    }
}
