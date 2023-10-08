package ru.netology.javaqa;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id) {
        super("Товар с ID = " + id + " уже есть в репозитории");
    }
}