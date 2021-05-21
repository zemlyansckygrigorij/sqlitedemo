package com.example.sqlitedemo.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WellTest {
    @Test
    public void makeTest(){
        Well w = new Well();
        w.setId(1);
        w.setName("qqq");
        assertEquals(1,w.getId());
        assertEquals("qqq",w.getName());
    }
}