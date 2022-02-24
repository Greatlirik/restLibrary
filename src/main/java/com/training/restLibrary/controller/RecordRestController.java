package com.training.restLibrary.controller;

import com.training.restLibrary.controller.dto.RecordDto;
import com.training.restLibrary.controller.mapper.RecordMapper;
import com.training.restLibrary.model.Record;
import com.training.restLibrary.service.RecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/records")
@Tag(name = "Record Controller", description = "Allows to perform CRUD operations on the record and search by parameters")
public class RecordRestController {

    /**
     * Autowired field recordService
     */
    private final RecordService recordService;

    /**
     * Autowired field readerService
     */
    private final RecordMapper mapper;

    /**
     * @param bookId
     * @param readerId
     * @param page
     * @return
     */
    @GetMapping
    public List<RecordDto> findAllRecords(
            @RequestParam(value = "bookId", required = false) Long bookId,
            @RequestParam(value = "readerId", required = false) Long readerId,
            @RequestParam Optional<Integer> page) {
        Page<Record> records = recordService.findAll(page, bookId, readerId);
        return records.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    /**
     * Get record by id
     *
     * @param recordId
     * @return recordDto
     */
    @GetMapping("{id}")
    public RecordDto getRecord(final @PathVariable("id") Long recordId) {
        return mapper.toDto(recordService.findById(recordId));
    }

    /**
     * Save record
     *
     * @param record
     * @return record
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Record saveRecord(final @RequestBody @Valid Record record) {
        return recordService.save(record);
    }

    /**
     * Delete record
     *
     * @param recordId
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteRecord(final @PathVariable("id") Long recordId) {
        recordService.deleteById(recordId);
    }

    /**
     * Update record
     *
     * @param recordId
     * @param record
     * @return record
     */
    @PutMapping("{id}")
    public Record updateRecord(final @PathVariable("id") Long recordId, final @RequestBody @Valid Record record) {
        return recordService.update(record, recordId);
    }

}
