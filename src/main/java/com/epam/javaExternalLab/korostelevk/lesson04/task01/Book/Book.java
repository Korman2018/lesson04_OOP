package com.epam.javaExternalLab.korostelevk.lesson04.task01.Book;

public class Book {

    private String bookName;

    private String authorName;

    private int numberOfPages;


    public Book(String bookName, String authorName, int numberOfPages) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.numberOfPages = numberOfPages;
    }

    public Book(String bookName, String authorName) {
        this(bookName, authorName, 0);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return bookName + "(author:" + (authorName == null ? "unknown" : authorName) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book bookForCompare = (Book) obj;
            return bookName.equals(bookForCompare.getBookName()) &&
                    authorName.equals(bookForCompare.getAuthorName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
