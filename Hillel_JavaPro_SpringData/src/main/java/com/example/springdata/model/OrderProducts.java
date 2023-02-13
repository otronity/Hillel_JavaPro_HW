package com.example.springdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(schema = "order_store", name = "orderproducts")
@IdClass(OrderProducts.class)
public class OrderProducts implements Serializable {

    @Id
    private int orderid;
    @Id
    private int productid;

}
