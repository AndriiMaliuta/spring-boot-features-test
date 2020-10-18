package com.anma.bh.sb.springtesting.core.repositories;

import com.anma.bh.sb.springtesting.core.models.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuildingRepository extends JpaRepository<Building, UUID> {

//    Page<Building> findAllByStreet(String street);
}
