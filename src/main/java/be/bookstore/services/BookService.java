package be.bookstore.services;

import be.bookstore.dtos.BookResponse;
import be.bookstore.mappers.BookMapper;
import be.bookstore.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public BookService(
            BookRepository bookRepository,
            BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookResponse findById(Long id) {
        var book = bookRepository
                .findById(id)
                .orElseThrow(
                        () ->
                                new EntityNotFoundException(
                                        String.format("Book with id = %s was not found.", id)));

        return bookMapper.bookToBookResponse(book);
    }

    public Page<BookResponse> findAll(Pageable pageable) {
        var bookPage = bookRepository.findAll(pageable);
        var bookList =
                bookPage.getContent().stream()
                        .map(bookMapper::bookToBookResponse)
                        .collect(Collectors.toList());
        return new PageImpl<>(bookList, pageable, bookPage.getTotalElements());
    }

    public List<BookResponse> findAll(Sort sort) {
        return bookRepository.findAll(sort).stream()
                .map(bookMapper::bookToBookResponse)
                .collect(Collectors.toList());
    }

    public Page<BookResponse> findAllByTitleOrAuthor(String query, Pageable pageable) {
        var bookPage = bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(query, query, pageable);
        var bookList = bookPage.stream()
                .map(bookMapper::bookToBookResponse)
                .collect(Collectors.toList());

        return new PageImpl<>(bookList, pageable, bookPage.getTotalElements());
    }
}
