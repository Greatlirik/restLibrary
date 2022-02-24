package com.training.restLibrary.controller.mapper;

import com.training.restLibrary.controller.dto.RecordDto;
import com.training.restLibrary.model.Record;
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
public class RecordMapper {

    /**
     * Autowired constructor field mapper
     */
    private final ModelMapper mapper;

    public RecordMapper() {
        this.mapper = new ModelMapper();
    }

    /**
     * Change DTO to entity
     *
     * @param dto
     * @return entity
     */
    public Record toEntity(RecordDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Record.class);
    }

    /**
     * Change Entity to DTO
     *
     * @param entity
     * @return dto
     */
    public RecordDto toDto(Record entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, RecordDto.class);
    }
}
