package com.example.sqlitedemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@AutoConfigureMockMvc
class WellControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private WellController controller;
    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}