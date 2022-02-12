package com.training.restLibrary.controller.mapper;

import com.training.restLibrary.controller.dto.BookDto;
import com.training.restLibrary.model.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class BookMapper {


    private final ModelMapper mapper;


    public Book toEntity(BookDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Book.class);
    }


    public BookDto toDto(Book entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, BookDto.class);
    }
}
