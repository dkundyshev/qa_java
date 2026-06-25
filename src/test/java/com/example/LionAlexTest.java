package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LionAlexTest {

    @Test
    public void testFriends() throws Exception {
        LionAlex alex = new LionAlex(mock(Feline.class));

        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void testPlaceOfLiving() throws Exception {
        LionAlex alex = new LionAlex(mock(Feline.class));

        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testKittens() throws Exception {
        LionAlex alex = new LionAlex(mock(Feline.class));

        assertEquals(0, alex.getKittens());
    }
}