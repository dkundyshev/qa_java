package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    @Test
    public void testGetSound() {
        Cat cat = new Cat(mock(Feline.class));

        String sound = cat.getSound();

        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFoodReturnsExpectedFood() throws Exception {
        Feline felineMock = mock(Feline.class);

        when(felineMock.eatMeat())
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(felineMock);

        List<String> food = cat.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFoodCallsEatMeat() throws Exception {
        Feline felineMock = mock(Feline.class);

        when(felineMock.eatMeat())
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(felineMock);

        cat.getFood();

        verify(felineMock, times(1)).eatMeat();
    }
}