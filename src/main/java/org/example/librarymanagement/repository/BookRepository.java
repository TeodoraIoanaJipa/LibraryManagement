package org.example.librarymanagement.repository;

import org.example.librarymanagement.aspect.BookValidator;
import org.example.librarymanagement.model.Author;
import org.example.librarymanagement.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Repository
public class BookRepository {

    @Autowired
    BookValidator bookValidator;

    private List<Book> allBooks = new ArrayList<Book>();

    public Book addBook(Book book) throws Exception {
        BindingResult bindingResult = new AbstractBindingResult("book") {
            @Override
            public Object getTarget() {
                return null;
            }

            @Override
            protected Object getActualFieldValue(String s) {
                return null;
            }
        };
        try {
            bookValidator.validate(book, bindingResult);
        } catch (Exception exception) {
            throw new Exception("Book data not valid");
        }
//        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult);
//            return null;
//        }

        allBooks.add(book);
        return book;
    }

    public void deleteBookById(UUID bookId) {
        for (Book book : allBooks) {
            if (book.getId().equals(bookId)) {
                allBooks.remove(book);
                System.out.println("Book with id " + bookId + " deleted");
            }
        }
    }

    public void lendBook(Book book) {
        book.setAvailable(false);
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
    }

    public List<Book> getAll() {
        return allBooks;
    }

    public List<Book> getBooksByAuthorFirstName(String firstName) {
        return allBooks.stream().filter(book -> book.getAuthor().getFirstName().equals(firstName)).collect(Collectors.toList());
    }

    public List<Book> getBooksByName(String name) {
        return allBooks.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
    }

    private List<Book> initializeBooks() {
        Author author = new Author("Liviu", "Rebreanu");
        Book book = new Book("Ion", author, false);

        Book secondBook = new Book("Padurea Spanzuratilor", author, true);
        return new ArrayList<Book>(asList(
                book,
                secondBook
        ));
    }
}
