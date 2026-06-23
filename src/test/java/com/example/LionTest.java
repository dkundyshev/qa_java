package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expectedMane;

    public LionTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testLionMane() throws Exception {
        Feline felineMock = mock(Feline.class);

        Lion lion = new Lion(sex, felineMock);

        assertEquals(expectedMane, lion.doesHaveMane());
    }

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

        List<String> food = lion.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
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