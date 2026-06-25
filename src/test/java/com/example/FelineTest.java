package com.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();

        List<String> result = feline.eatMeat();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();

        String result = feline.getFamily();

        assertEquals("Кошачьи", result);
    }

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();

        int result = feline.getKittens();

        assertEquals(1, result);
    }

    @Test
    public void testGetKittensWithParam() {
        Feline feline = new Feline();

        int result = feline.getKittens(5);

        assertEquals(5, result);
    }
}