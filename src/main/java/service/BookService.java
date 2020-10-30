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

    public void addBook(String bookName, String firstName, String lastName){
        Book newBook = new Book();
        newBook.setName(bookName);
        Author author1 = new Author(firstName, lastName);
        newBook.setAuthor(author1);
        System.out.println("Done");
        bookRepository.addBook(newBook);
    }

    public void deleteBook(Integer id){
        bookRepository.deleteBookById(id);
    }
}
