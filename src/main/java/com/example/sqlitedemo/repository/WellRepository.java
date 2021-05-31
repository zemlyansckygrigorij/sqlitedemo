package com.example.sqlitedemo.repository;

import com.example.sqlitedemo.entity.Well;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WellRepository extends JpaRepository<Well, Long> {
    @Query("SELECT e FROM Well e WHERE e.name = :name")
    public Well getWellByWellname(@Param("name") String name);
}

