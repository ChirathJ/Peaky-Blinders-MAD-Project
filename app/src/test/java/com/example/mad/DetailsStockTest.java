package com.example.mad;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class DetailsStockTest {

    @Test
    public void calculation() {
        int result = DetailsStock.calculation("50","1000");
        assertEquals(50000, result);
    }
}