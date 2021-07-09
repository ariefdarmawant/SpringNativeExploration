package com.spring.springCRUD.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "balances", uniqueConstraints = {@UniqueConstraint(columnNames = {"item_id", "employee_id"})})
public class Balance {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "amount", nullable = false)
    @Size(min = 0, message = "Amount cannot be negative.")
    private int amount;

    @Column(name = "spent_amount")
    @Size(min = 0, message = "Amount cannot be negative.")
    private int spentAmount;
}
