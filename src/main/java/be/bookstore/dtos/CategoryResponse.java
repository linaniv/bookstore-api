package be.bookstore.dtos;

import lombok.Data;

@Data
public class CategoryResponse {

    private Long id;

    private String name;

    private String slug;
}
