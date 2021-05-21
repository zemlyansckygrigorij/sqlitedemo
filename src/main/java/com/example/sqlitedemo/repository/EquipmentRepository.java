package com.example.sqlitedemo.repository;

import com.example.sqlitedemo.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    @Query("SELECT e FROM Equipment e WHERE e.name = :name")
    public Equipment getEquipmentByEquipmentname(@Param("name") String name);

}
