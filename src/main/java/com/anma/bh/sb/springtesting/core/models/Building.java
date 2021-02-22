package com.anma.bh.sb.springtesting.core.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@Table(name = "buildings")
@NoArgsConstructor
@AllArgsConstructor
public class Building {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private UUID id;

    private String street;

    private int houseNumber;

    private int entrance;

}
