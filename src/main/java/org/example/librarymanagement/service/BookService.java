package org.example.librarymanagement.service;

import org.example.librarymanagement.dto.BookDto;
import org.example.librarymanagement.model.Author;
import org.example.librarymanagement.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.librarymanagement.repository.BookRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(BookDto bookDto) throws Exception {
        Author author1 = new Author(bookDto.getAuthor().getFirstName(), bookDto.getAuthor().getLastName());
        Book newBook = new Book(bookDto.getName(), author1, bookDto.getAvailable());
        bookRepository.addBook(newBook);
    }

    public void loanBook(Book book) {
        bookRepository.lendBook(book);
    }

    public void returnBook(Book book) {
        bookRepository.returnBook(book);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteBookById(id);
    }

    public List<BookDto> getBooksByAuthorFirstName(String firstName){
        List<Book> books = bookRepository.getBooksByAuthorFirstName(firstName.trim());
        return books.stream().map(BookDto::new).collect(Collectors.toList());
    }

    public List<BookDto> getBooksByName(String name){
        List<Book> books = bookRepository.getBooksByName(name.trim());
        return books.stream().map(BookDto::new).collect(Collectors.toList());
    }

    public List<BookDto> getAll() {
        List<Book> books = bookRepository.getAll();
        return books.stream().map(BookDto::new).collect(Collectors.toList());
    }
}
