package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        Feline felineMock = mock(Feline.class);

        new Lion("Кто-то", felineMock);
    }

    @Test
    public void testGetKittensReturnsValue() throws Exception {
        Feline felineMock = mock(Feline.class);

        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", felineMock);

        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetKittensCallsMethod() throws Exception {
        Feline felineMock = mock(Feline.class);

        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", felineMock);

        lion.getKittens();

        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFoodReturnsFood() throws Exception {
        Feline felineMock = mock(Feline.class);

        when(felineMock.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", felineMock);

        assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                lion.getFood()
        );
    }

    @Test
    public void testGetFoodCallsMethod() throws Exception {
        Feline felineMock = mock(Feline.class);

        when(felineMock.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", felineMock);

        lion.getFood();

        verify(felineMock, times(1)).getFood("Хищник");
    }
}