package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Book book = new Book(1, "Emma", 1200, "Jane Austen", 325, 1985);
    private Smartphone smartphone = new Smartphone(6, "7", 25000, "Apple");

    @Test
    void shouldNotMatchesSearch() {
        boolean actual = smartphone.matches(smartphone, "");
        assertEquals(false, actual);
    }

    @Test
    void bookShouldNotMatchesSmartphone() {
        boolean actual = smartphone.matches(book, "Jane Austen");
        assertEquals(false, actual);
    }

    @Test
    void shouldMatchesBookByTitle() {
        boolean actual = smartphone.matches(smartphone, "7");
        assertEquals(true, actual);
    }

    @Test
    void shouldMatchesBookByManufacturer() {
        boolean actual = smartphone.matches(smartphone, "Apple");
        assertEquals(true, actual);
    }
}