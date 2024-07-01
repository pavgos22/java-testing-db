package com.crud.javacrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

@Data
@Entity
@Table(name="CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phone;

}
