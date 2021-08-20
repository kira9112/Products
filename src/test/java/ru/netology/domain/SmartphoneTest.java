package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {


    @Test
    public void shouldUseEquals() {
        Smartphone first = new Smartphone(6, "7", 25000, "Apple");
        Smartphone second = new Smartphone(6, "7", 25000, "Apple");
        assertEquals(first, second);
    }

    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Smartphone smartphone = new Smartphone();

    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Smartphone();
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;

        }
    }


    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Smartphone();
        product.toString();
    }
}