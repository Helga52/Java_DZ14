
package ru.netology.javaqa;

import com.sun.nio.sctp.Association;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {

    @Test
    public void shouldProductRemoveExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Планшет", 35000);
        Product product2 = new Product(2, "Телевизор", 75000);
        Product product3 = new Product(3, "Холодильник", 62000);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldProductRemoveNotExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Планшет", 35000);
        Product product2 = new Product(2, "Телевизор", 75000);
        Product product3 = new Product(3, "Холодильник", 62000);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        //repo.remove(4);
        //Product[] actual = repo.findAll();
        //Product[] expected = {product1, product2, product3};

        //Assertions.assertArrayEquals(expected, actual);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4));

    }

    @Test
    public void shouldProductAddNotExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Планшет", 35000);
        Product product2 = new Product(2, "Телевизор", 75000);
        Product product3 = new Product(3, "Холодильник", 62000);
        Product product4 = new Product(4, "Пылесос", 17000);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product4};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldProductAddExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Планшет", 35000);
        Product product2 = new Product(3, "Телевизор", 75000);
        Product product3 = new Product(3, "Холодильник", 62000);
        Product product4 = new Product(4, "Пылесос", 17000);
        repo.add(product1);
        repo.add(product2);
        //repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(AlreadyExistsException.class,
                () -> repo.add(product3));

    }
}