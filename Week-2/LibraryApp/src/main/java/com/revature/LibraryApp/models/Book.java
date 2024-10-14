package com.revature.LibraryApp.models;

import java.sql.Date;

public class Book {
    private int bookId;
    private String title;
    private String genre;
    private Date publicationDate;
    private Author author;
    private Member checkedOutBy;

    // Constructor
    public Book(int bookId, String title, String genre, Date publicationDate, Author author, Member checkedOutBy) {
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.author = author;
        this.checkedOutBy = checkedOutBy;
    }

    public Book(){}

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Member getCheckedOutBy() {
        return checkedOutBy;
    }

    public void setCheckedOutBy(Member checkedOutBy) {
        this.checkedOutBy = checkedOutBy;
    }

    // toString method
    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", publicationDate=" + publicationDate +
                ", author=" + author +
                ", checkedOutBy=" + checkedOutBy +
                '}';
    }
}