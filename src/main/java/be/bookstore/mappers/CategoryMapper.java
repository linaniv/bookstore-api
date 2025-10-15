package be.bookstore.mappers;

import be.bookstore.dtos.CategoryResponse;
import be.bookstore.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse categoryToCategoryResponse(Category category);

}
