package com.example.tests;

import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private final Feline feline = new Feline();

    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFamilyReturnsCatsFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParametersReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParametersReturnsKittensCount() {
        assertEquals(5, feline.getKittens(5));
    }
}