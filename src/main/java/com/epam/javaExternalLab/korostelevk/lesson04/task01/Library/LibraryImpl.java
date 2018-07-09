package com.epam.javaExternalLab.korostelevk.lesson04.task01.Library;


import com.epam.javaExternalLab.korostelevk.lesson04.task01.Book.Book;

public class LibraryImpl implements Library {

    private Book[] books;

    private int size;

    public LibraryImpl() {
        books = new Book[100];
    }

    public LibraryImpl(int capacity) {
        books = new Book[capacity];
    }

    @Override
    public boolean addBook(Book book) {
        if (size == books.length) {
            return false;
        }
        if (searchBookIndex(book) != -1) {
            return true;
        }

        books[size++] = book;
        return true;
    }

    @Override
    public Book delBookByName(String name) {
        int findIndex = searchBookIndex(name);
        if (findIndex == -1) {
            return null;
        }
        Book deletedBook = books[findIndex];
        size--;
        books[findIndex] = books[size];
        return deletedBook;
    }

    @Override
    public boolean delBook(Book book) {
        int findIndex = searchBookIndex(book);
        if (findIndex == -1) {
            return false;
        }
        size--;
        books[findIndex] = books[size];
        return true;
    }

    @Override
    public Book findBookByName(String name) {
        int findIndex = searchBookIndex(name);
        if (findIndex >= 0) {
            return books[findIndex];
        }
        return null;
    }

    @Override
    public Book[] getAllBooks() {
        Book[] booksCopy = new Book[size];
        System.arraycopy(books, 0, booksCopy, 0, size);
        return booksCopy;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    private int searchBookIndex(String name) {
        for (int i = 0; i < size; i++) {
            if (books[i].getBookName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int searchBookIndex(Book book) {
        for (int i = 0; i < size; i++) {
            if (books[i].equals(book)) {
                return i;
            }
        }
        return -1;
    }
}
