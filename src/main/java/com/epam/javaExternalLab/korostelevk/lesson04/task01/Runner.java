package com.epam.javaExternalLab.korostelevk.lesson04.task01;

import com.epam.javaExternalLab.korostelevk.lesson04.task01.Book.Book;
import com.epam.javaExternalLab.korostelevk.lesson04.task01.Demo.DemoService;
import com.epam.javaExternalLab.korostelevk.lesson04.task01.Demo.DemoServiceImpl;
import com.epam.javaExternalLab.korostelevk.lesson04.task01.Library.LibraryImpl;

public class Runner {
    public static void main(String[] args) {
        DemoService demoService = new DemoServiceImpl();
        demoService.allTests(new LibraryImpl(), new Book("War and Peace", "Leo Tolstoy", 4000));
    }
}
