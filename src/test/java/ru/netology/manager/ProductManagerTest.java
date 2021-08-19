package ru.netology.manager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Emma", 1200, "Jane Austen", 325, 1985);
    private Book secondBook = new Book(1, "Anna Karenina", 1100, "Leo Tolstoy", 1242, 1878);
    private Smartphone firstSmartphone = new Smartphone(3, "4", 10000, "Apple");
    private Smartphone secondSmartphone = new Smartphone(4, "5", 15000, "Apple");


    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);

    }


    @Test
    public void shouldFindSeveralByBookAuthor() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Leo Tolstoy");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByBookTitle() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Emma");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneManufacturer() {
        Product[] expected = new Product[]{firstSmartphone, secondSmartphone};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneTitle() {
        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("5");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFind() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Cinderella");
        assertArrayEquals(expected, actual);
    }
}