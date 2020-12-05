package org.example.librarymanagement.controller;

import org.example.librarymanagement.dto.BookDto;
import org.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get-all")
    public List<BookDto> findAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/get-book/{name}")
    public ResponseEntity<List<BookDto>> findBookByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(bookService.getBooksByName(name), OK);
    }

    @GetMapping("/get-book/author")
    public ResponseEntity<List<BookDto>> findBookByAuthorFirstName(@RequestParam(name = "firstName") String firstName) {
        return new ResponseEntity<>(bookService.getBooksByAuthorFirstName(firstName), OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveBook(@RequestBody BookDto bookDto) {
        try {
            bookService.addBook(bookDto);
        } catch (Exception e) {
            return new ResponseEntity<>(BAD_REQUEST);
        }
        return new ResponseEntity<>(OK);
    }

}
