package com.example.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void lionHasManeIfMale() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionHasNoManeIfFemale() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionConstructorThrowsIfSexIsInvalid() throws Exception {
        new Lion("Неизвестно", felineMock);
    }

    @Test
    public void getKittensDelegatesToFeline() throws Exception {
        when(felineMock.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(5, lion.getKittens());
    }

    @Test
    public void getFoodDelegatesToFeline() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Мясо"));
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(List.of("Мясо"), lion.getFood());
    }
}