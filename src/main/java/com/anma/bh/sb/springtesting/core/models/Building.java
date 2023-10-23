package com.anma.bh.sb.springtesting.core.models;

import jakarta.persistence.*;
import java.util.UUID;

@Table(name = "buildings")
public class Building {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private UUID id;

    private String street;

    private int houseNumber;

    private int entrance;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getEntrance() {
        return entrance;
    }

    public void setEntrance(int entrance) {
        this.entrance = entrance;
    }
}
