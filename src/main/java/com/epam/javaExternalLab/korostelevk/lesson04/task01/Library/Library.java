package com.epam.javaExternalLab.korostelevk.lesson04.task01.Library;

import com.epam.javaExternalLab.korostelevk.lesson04.task01.Book.Book;

public interface Library {

    boolean addBook(Book book);

    Book delBookByName(String name);

    boolean delBook(Book book);

    Book findBookByName(String name);

    Book[] getAllBooks();

    int getSize();

    void clear();
}
