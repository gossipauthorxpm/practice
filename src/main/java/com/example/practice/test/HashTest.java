package com.example.practice.test;

import com.example.practice.data.digest.Hash;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HashTest {

    @Test
    public void testVerifyHash() {
        assertEquals(true, Hash.verifyHash("feb53c12bce3021b895caa169dcc09bd", "5768853"));
    }

    @Test
    public void testGetHash() {
        assertEquals("feb53c12bce3021b895caa169dcc09bd", Hash.getHash("5768853"));
    }

}