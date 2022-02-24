package com.training.restLibrary.controller.mapper;

import com.training.restLibrary.controller.dto.ReaderDto;
import com.training.restLibrary.model.Reader;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ReaderMapper {

    private final ModelMapper mapper;

    private String generateFullName(String firstname, String lastname) {
        return firstname + " " + lastname;
    }

    public ReaderMapper() {
        this.mapper = new ModelMapper();
        mapper.createTypeMap(Reader.class, ReaderDto.class)
                .addMappings(
                        new PropertyMap<>() {
                            @Override
                            protected void configure() {
                                using(
                                        reader -> generateFullName(
                                                ((Reader) reader.getSource()).getFirstName(),
                                                ((Reader) reader.getSource()).getLastName()
                                        )
                                ).map(source, destination.getFullName());
                            }
                        }
                );
    }


    public Reader toEntity(final ReaderDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Reader.class);
    }


    public ReaderDto toDto(final Reader entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ReaderDto.class);
    }
}
