package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testHerbivore() throws Exception {
        Animal animal = new Animal();
        assertEquals(List.of("Трава", "Различные растения"),
                animal.getFood("Травоядное"));
    }

    @Test
    public void testPredator() throws Exception {
        Animal animal = new Animal();
        assertEquals(List.of("Животные", "Птицы", "Рыба"),
                animal.getFood("Хищник"));
    }

    @Test(expected = Exception.class)
    public void testUnknown() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Кто-то");
    }

    @Test
    public void testFamily() {
        Animal animal = new Animal();
        assertNotNull(animal.getFamily());
    }
}