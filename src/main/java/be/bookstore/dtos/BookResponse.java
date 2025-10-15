package be.bookstore.dtos;

import be.bookstore.entities.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class BookResponse {

    private Long id;

    private String title;

    private String author;

    private BigDecimal price;

    private String currency;

    private String isbn;

    private String description;

    private Integer stock;

    private String imageUrl;

    private Set<Category> categories;

}
