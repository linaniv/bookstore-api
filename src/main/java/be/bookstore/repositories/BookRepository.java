package be.bookstore.repositories;

import be.bookstore.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    Page<Book> findAll(Pageable pageable);

    @Override
    List<Book> findAll(Sort sort);

    @Override
    Optional<Book> findById(Long id);

    Page<Book> findAllByTitleOrAuthor(String title, String author, Pageable pageable);
}

