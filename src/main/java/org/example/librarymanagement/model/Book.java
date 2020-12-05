package org.example.librarymanagement.model;


import java.util.Objects;
import java.util.UUID;

public class Book {
    private UUID id;
    private String name;
    private Author author;
    private Boolean isAvailable;

    public Book() {
    }

    public Book(String name, Author author, Boolean isAvailable) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
