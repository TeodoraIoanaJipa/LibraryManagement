package org.example.librarymanagement.dto;

import org.example.librarymanagement.model.Author;
import org.example.librarymanagement.model.Book;

public class BookDto {
    private String name;
    private Author author;
    private Boolean isAvailable;

    public BookDto() {
    }

    public BookDto(Book book){
        name = book.getName();
        author = book.getAuthor();
        isAvailable = book.getAvailable();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }


}
