package ru.netology.javaqa;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {

        super("Товар с ID = " + id + " не найден");
    }

}