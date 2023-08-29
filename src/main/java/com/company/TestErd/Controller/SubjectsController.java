package com.company.TestErd.Controller;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SimpleCrud;
import com.company.TestErd.Dto.SubjectsDto;
import com.company.TestErd.Service.SubjectsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "subject")
public class SubjectsController implements SimpleCrud<Integer, SubjectsDto> {
    private final SubjectsService service;

    @Override
    @Operation(
            description = "this method create subject data and save to database",
            summary = "POST method and the method create subject",
            method = "POST MAPPING")
    @PostMapping
    public ResponseDto<SubjectsDto> create(@RequestBody SubjectsDto dto) {
        return service.create(dto);
    }

    @Override
    @Operation(
            description = "this method get subject data ",
            summary = "GET method and the method get subject method",
            method = "GET MAPPING")
    @GetMapping(value = "/{id}")
    public ResponseDto<SubjectsDto> get(@PathVariable(value = "id") Integer entityId) {
        return service.get(entityId);
    }

    @Override
    @Operation(
            description = "this method update subject data and save to database",
            summary = "PUT method and the method update subject",
            method = "PUT MAPPING")
    @PutMapping(value = "/{id}")
    public ResponseDto<SubjectsDto> update(@PathVariable(value = "id") Integer entityId,
                                           @RequestBody SubjectsDto dto) {
        return service.update(entityId, dto);
    }

    @Override
    @Operation(
            description = "this method delete subject data and remove from database",
            summary = "POST method and the method create subject",
            method = "POST MAPPING")
    @DeleteMapping(value = "/{id}")
    public ResponseDto<SubjectsDto> delete(@PathVariable(value = "id") Integer entityId) {
        return service.delete(entityId);
    }

    @Override
    @Operation(
            description = "this method getAll subject data ",
            summary = "GET method and the method Get all subject",
            method = "GET MAPPING")
    @GetMapping(value = "/getAll")
    public ResponseDto<List<SubjectsDto>> getAll() {
        return service.getAll();
    }
}
