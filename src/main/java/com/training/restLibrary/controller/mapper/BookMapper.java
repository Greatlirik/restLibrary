package com.training.restLibrary.controller.mapper;

import com.training.restLibrary.controller.dto.BookDto;
import com.training.restLibrary.model.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * AccountRESTController
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@Component
public class BookMapper {

    /**
     * Autowired constructor field mapper
     */
    private final ModelMapper mapper;

    /**
     * Change DTO to entity
     *
     * @param dto
     * @return entity
     */
    public Book toEntity(BookDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Book.class);
    }

    /**
     * Change Entity to DTO
     *
     * @param entity
     * @return dto
     */
    public BookDto toDto(Book entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, BookDto.class);
    }
}
