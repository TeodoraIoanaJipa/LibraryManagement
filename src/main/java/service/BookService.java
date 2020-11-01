package service;

import model.Author;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(String bookName, String firstName, String lastName) {
        Book newBook = new Book();
        newBook.setName(bookName);
        Author author1 = new Author(firstName, lastName);
        newBook.setAuthor(author1);
        bookRepository.addBook(newBook);
    }

    public void loanBook(Book book) {
        bookRepository.lendBook(book);
    }

    public void returnBook(Book book) {
        bookRepository.returnBook(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteBookById(id);
    }

}
