package repository;

import aspect.BookValidator;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    BookValidator bookValidator;

    private List<Book> allBooks = new ArrayList<Book>();

    public Book addBook(@Valid Book book){
        System.out.println("Book added");
        allBooks.add(book);
        return book;
    }

    public void deleteBookById(Integer bookId){
        System.out.println("Book with id "+ bookId + " deleted");
    }

    public void returnBook(Book book){
        book.setAvailable(true);
        allBooks.add(book);
    }

    public void lendBook(Book book){
        book.setAvailable(false);
        allBooks.remove(book);
    }

    
}
