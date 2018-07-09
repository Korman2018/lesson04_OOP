package com.epam.javaExternalLab.korostelevk.lesson04.task01.Demo;

import com.epam.javaExternalLab.korostelevk.lesson04.task01.Book.Book;
import com.epam.javaExternalLab.korostelevk.lesson04.task01.Library.Library;
import com.epam.javaExternalLab.korostelevk.lesson04.task01.Library.LibraryImpl;

public class DemoServiceImpl implements DemoService {

    private Library library;

    @Override
    public void allTests(Library library, Book book) {
        this.library = library;

        System.out.println("all tests");
        fillLibrary();
        checkAdd(book);
        checkFindBook(book.getBookName());
        checkRemove(book.getBookName());
        library.addBook(book);
        checkRemove(book);
        checkAddForFullLibrary(book);
    }

    private void fillLibrary() {
        library.addBook(new Book("Petr 1", "Alexey Tolstoy", 602));
        library.addBook(new Book("The Three Musketeers", "Alexandre Dumas", 520));
        library.addBook(new Book("Mieko and the Fifth Treasure", "Eleanor Coerr", 745));
        library.addBook(new Book("The Outsiders", "S.E. Hinton", 445));
        library.addBook(new Book("The House On Mango Street", "Sandra Cisneros", 680));
        library.addBook(new Book("The Old Man and the Sea", "Ernest Hemmingway", 645));
        library.addBook(new Book("The Giver", "Lois Lowry", 643));
        library.addBook(new Book("The gate", null));
    }

    private void printLibrary() {
        for (Book book : library.getAllBooks()) {
            System.out.println(book);
        }
    }

    private void checkAdd(Book book) {
        System.out.println("\ncheckAdd test\nИсходная библиотека:");
        printLibrary();
        library.addBook(book);
        System.out.println("\nБиблиотека c добавленной книгой: " + book);
        printLibrary();
    }

    private void checkAddForFullLibrary(Book book) {
        System.out.println("\ncheckAddForFullLibrary test");

        StringBuilder sb = new StringBuilder();
        library = new LibraryImpl(8);

        fillLibrary();
        sb.append("Исходная библиотека(емкость= ").append(library.getAllBooks().length)
                .append(", всего книг=").append(library.getSize()).append(")");
        System.out.println(sb.toString());
        printLibrary();

        library.addBook(book);
        sb = new StringBuilder();
        sb.append("\nБиблиотека после добавления книги: ").append(book).append("(емкость= ")
                .append(library.getAllBooks().length).append(", всего книг=").append(library.getSize()).append(")");
        System.out.println(sb.toString());
        printLibrary();
    }

    private void checkRemove(Book book) {
        checkRemoveMessage();
        System.out.println(book);
        library.delBook(book);
        printLibrary();
    }

    private void checkRemove(String bookName) {
        checkRemoveMessage();
        System.out.println("с названием " + bookName);
        library.delBookByName(bookName);
        printLibrary();
    }

    private void checkRemoveMessage() {
        System.out.println("\ncheckRemove test");
        System.out.println("Исходная библиотека:");
        printLibrary();
        System.out.print("\nБиблиотека c удаленной книгой ");
    }

    private void checkFindBook(String bookName) {
        System.out.println("\ncheckFindBook(bookName) test");
        System.out.println("Исходная библиотека:");
        printLibrary();
        System.out.println("\nПоиск книги с именем: " + bookName);
        System.out.println("Найдена книга: " + library.findBookByName(bookName));
    }
}
