package com.tianjiqx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tianjiqx on 2017/6/25.
 */
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String bookName;
    private String author;
    private String description;
    private String publishDate;

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public Book(String bookName, String author, String description) {
        this.bookName = bookName;
        this.author = author;
        this.description = description;
    }

    public Book(String bookName, String author, String description, String publishDate) {
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }



}
