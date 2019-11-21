package com.anma.bh.sb.springtesting.repositories;

import com.anma.bh.sb.springtesting.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuildingRepository extends JpaRepository<Building, UUID> {
}
