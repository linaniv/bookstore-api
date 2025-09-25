package be.bookstore.repositories;

import be.bookstore.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    Page<Category> findAll(Pageable pageable);

    @Override
    List<Category> findAll(Sort sort);

    @Override
    Optional<Category> findById(Long id);

    Optional<Category> findByName(String name);
}
