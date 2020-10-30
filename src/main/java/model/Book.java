package model;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

public class Book {
    @NotNull
    private Integer id;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    private Author author;
    private Boolean isAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
