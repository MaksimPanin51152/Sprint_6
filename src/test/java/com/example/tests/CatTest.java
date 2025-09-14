package com.example.tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CatTest {

    private Feline felineMock;
    private Cat cat;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsPredatorFoodList() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы"));
        assertEquals(List.of("Животные", "Птицы"), cat.getFood());
    }
}