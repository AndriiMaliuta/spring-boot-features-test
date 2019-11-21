package com.anma.bh.sb.springtesting.models;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Building {

    @Id
    @Column(name = "building_id")
    private UUID id;

    private String street;

    private short houseNumber;

    private short entrance;




}
