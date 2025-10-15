package be.bookstore.mappers;


import be.bookstore.dtos.BookResponse;
import be.bookstore.entities.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponse bookToBookResponse(Book book);

}
