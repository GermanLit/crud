package com.german.crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity//делает из обычного класса модель
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Book() {
    }

    public Book(String title_book, String author, String book_description, String link_to_book) {
        this.title_book = title_book;
        this.author = author;
        this.book_description = book_description;
        this.link_to_book = link_to_book;
    }

    private String title_book, author, book_description, link_to_book;
    private int views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle_book() {
        return title_book;
    }

    public void setTitle_book(String title_book) {
        this.title_book = title_book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public String getLink_to_book() {
        return link_to_book;
    }

    public void setLink_to_book(String link_to_book) {
        this.link_to_book = link_to_book;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }


}
