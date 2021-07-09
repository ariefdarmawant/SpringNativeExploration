package com.spring.springCRUD.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid;

    @NotNull(message = "Name cannot be null.")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Description cannot be null.")
    @Column(nullable = false)
    private String description;
}
