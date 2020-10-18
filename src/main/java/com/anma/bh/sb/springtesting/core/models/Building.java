package com.anma.bh.sb.springtesting.core.models;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Building {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private UUID id;

    private String street;

    private short houseNumber;

    private short entrance;




}
