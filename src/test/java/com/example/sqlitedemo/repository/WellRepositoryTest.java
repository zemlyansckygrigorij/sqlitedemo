package com.example.sqlitedemo.repository;

import com.example.sqlitedemo.entity.Well;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class WellRepositoryTest {
    @Autowired
    private WellRepository repository;
    @Test
    public void test() {
        long countFirst = repository.count();
        assertEquals(3, countFirst);
        List<Well> opt = repository.findAll();
        for(int i = 0;i<opt.size();i++){
            assertEquals(opt.get(i).getEquipments().size(), 1);
        }
    }
}