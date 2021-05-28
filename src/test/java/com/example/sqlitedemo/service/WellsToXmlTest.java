package com.example.sqlitedemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class WellsToXmlTest {

    @Autowired
    private WellsToXml wellsToXml ;

    @Test
    void contextLoads() {
    }

    @Test
    public void makeTest(){
        File f = new File("C:\\Users\\cnk-1\\IdeaProjects\\sqlitedemo\\1.xml");
        assertFalse(f.exists());
        wellsToXml.convert(f.getPath());
        assertTrue(f.exists());
        f.deleteOnExit();

    }

}