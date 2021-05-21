package com.example.sqlitedemo.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {
    @Test
    public void makeTest(){
        Equipment e = new Equipment();
        e.setId(1);
        e.setName("qqq");
        assertEquals(1,e.getId());
        assertEquals("qqq",e.getName());
    }
}