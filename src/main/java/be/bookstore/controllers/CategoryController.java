package be.bookstore.controllers;

import be.bookstore.dtos.CategoryResponse;
import be.bookstore.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryResponse findById(@PathVariable Long id) {
        return this.categoryService.findById(id);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CategoryResponse> findAll(Pageable pageable) {
        return this.categoryService.findAll(pageable);
    }

    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CategoryResponse> findAll(Sort sort) {
        return this.categoryService.findAll(sort);
    }

}
