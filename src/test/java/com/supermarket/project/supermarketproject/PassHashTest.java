package com.supermarket.project.supermarketproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PassHashTest {

    @Test
    void TestReturnsStringValid()
    {
        String hash1 = PassHash.hash("hello");
        String hash2 = PassHash.hash("hello");
        assertEquals(hash1,hash2);
    }
    @Test
    void TestReturnsStringNotEqual()
    {
        String hash1 = PassHash.hash("No way");
        String hash2 = PassHash.hash("Am not");
        assertNotEquals(hash1,hash2);
    }
    @Test
    void TestReturnsStringNotEqualDifferentCase()
    {
        String hash1 = PassHash.hash("NO WAY");
        String hash2 = PassHash.hash("no way");
        assertNotEquals(hash1, hash2);
    }
}