package com.example.sqlitedemo.service;

import java.util.UUID;

public class RandomStringGenerator {
    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        uuid.replace("-", "");
        return  uuid;
    }
}
