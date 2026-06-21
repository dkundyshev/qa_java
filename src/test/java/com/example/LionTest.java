package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void testMaleLionHasMane() throws Exception {
        Feline felineMock = mock(Feline.class);

        Lion lion = new Lion("Самец", felineMock);

        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionNoMane() throws Exception {
        Feline felineMock = mock(Feline.class);

        Lion lion = new Lion("Самка", felineMock);

        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        Feline felineMock = mock(Feline.class);

        new Lion("Кто-то", felineMock);
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline felineMock = mock(Feline.class);

        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", felineMock);

        assertEquals(3, lion.getKittens());

        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = mock(Feline.class);

        when(felineMock.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", felineMock);

        List<String> food = lion.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);

        verify(felineMock, times(1)).getFood("Хищник");
    }
}