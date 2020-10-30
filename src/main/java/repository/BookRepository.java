package repository;

import model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<Book> allBooks = new ArrayList<>();

    public Book addBook(Book book){
        System.out.println("Book added");
        allBooks.add(book);
        return book;
    }

    public void deleteBookById(Integer bookId){
        System.out.println("Book with id "+ bookId + " deleted");
    }

    public void returnBook(Book book){
        book.setAvailable(true);
    }

    public void lendBook(Book book){
        book.setAvailable(false);
    }
}
