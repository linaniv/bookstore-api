package be.bookstore.services;

import be.bookstore.dtos.CategoryResponse;
import be.bookstore.mappers.CategoryMapper;
import be.bookstore.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryService(
            CategoryRepository categoryRepository,
            CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryResponse findById(Long id) {
        var category = categoryRepository
                .findById(id)
                .orElseThrow(
                        () ->
                                new EntityNotFoundException(
                                        String.format("Category with id = %s was not found.", id)));

        return categoryMapper.categoryToCategoryResponse(category);
    }

    public Page<CategoryResponse> findAll(Pageable pageable) {
        var categoryPage = categoryRepository.findAll(pageable);
        var categoryList =
                categoryPage.getContent().stream()
                        .map(categoryMapper::categoryToCategoryResponse)
                        .collect(Collectors.toList());
        return new PageImpl<>(categoryList, pageable, categoryPage.getTotalElements());
    }

    public List<CategoryResponse> findAll(Sort sort) {
        return categoryRepository.findAll(sort).stream()
                .map(categoryMapper::categoryToCategoryResponse)
                .collect(Collectors.toList());
    }
}
