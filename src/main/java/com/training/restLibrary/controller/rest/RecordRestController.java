package com.training.restLibrary.controller.rest;

import com.training.restLibrary.model.Record;
import com.training.restLibrary.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/records")
public class RecordRestController {

    private final RecordService recordService;

    @GetMapping
    public Page<Record> findAllRecords(
            @RequestParam(value = "bookId", required = false) Long bookId,
            @RequestParam(value = "readerId", required = false) Long readerId,
            @RequestParam Optional<Integer> page) {
        Page<Record> records;
        if (bookId != null) {
            records = recordService.findAllByBook(bookId, page);
        } else if (readerId != null) {
            records = recordService.findAllByReader(readerId, page);
        } else {
            records = recordService.findAll(page);
        }
        return records;
    }

    @GetMapping("{id}")
    public Record getRecord(final @PathVariable("id") Long recordId) {
        return recordService.findById(recordId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Record saveRecord(final @RequestBody @Valid Record record) {
        return recordService.save(record);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteRecord(final @PathVariable("id") Long recordId) {
        recordService.deleteById(recordId);
    }

    @PutMapping("{id}")
    public Record updateRecord(final @PathVariable("id") Long recordId, final @RequestBody @Valid Record record) {
        return recordService.update(record, recordId);
    }

}
