package be.bookstore.controllers;

import be.bookstore.entities.Book;
import be.bookstore.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Book findById(@PathVariable Long id) {
        return this.bookService.findById(id);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<Book> findAll(Pageable pageable) {
        return this.bookService.findAll(pageable);
    }

    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Book> findAll(Sort sort) {
        return this.bookService.findAll(sort);
    }

    @GetMapping("/search")
    @ResponseStatus(code = HttpStatus.OK)
    public Page<Book> findAllByTitleOrAuthor(String query, Pageable pageable) {
        return this.bookService.findAllByTitleOrAuthor(query, pageable);
    }
}
