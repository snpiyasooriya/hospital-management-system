package com.synotech.hos.controllers;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, length = 20)
    private String medicine;

    @Column(nullable = false, length = 20)
    private String brand;

    @Column(nullable = false)
    private Long qty;

    public Inventory(Long id, String medicine, String brand, Long qty) {
        this.id = id;
        this.medicine = medicine;
        this.brand = brand;
        this.qty = qty;
    }

    public Inventory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", medicine='" + medicine + '\'' +
                ", brand='" + brand + '\'' +
                ", qty=" + qty +
                '}';
    }
}
