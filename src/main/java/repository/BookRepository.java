package repository;

import aspect.BookValidator;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    BookValidator bookValidator;

    private List<Book> allBooks = new ArrayList<Book>();

    public Book addBook(Book book){
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
        }catch (Exception exception){

        }
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return null;
        }

        System.out.println("Book added");
        allBooks.add(book);
        return book;
    }

    public void deleteBookById(Integer bookId){
        for(Book book:allBooks){
            if(book.getId().equals(bookId)){
                allBooks.remove(book);
                System.out.println("Book with id "+ bookId + " deleted");
            }
        }
    }

    public void lendBook(Book book){
        book.setAvailable(false);
    }

    public void returnBook(Book book){
        book.setAvailable(true);
    }


}
