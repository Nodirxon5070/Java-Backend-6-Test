package com.company.TestErd.Controller;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SimpleCrud;
import com.company.TestErd.Dto.TeachersDto;
import com.company.TestErd.Service.TeachersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "teacher")
public class TeachersController implements SimpleCrud<Integer, TeachersDto> {
    private final TeachersService service;

    @Override
    @Operation(
            description = "this method create teachers data and save to database",
            summary = "POST method and the method create teachers",
            method = "POST MAPPING")
    @PostMapping
    public ResponseDto<TeachersDto> create(@RequestBody TeachersDto dto) {
        return service.create(dto);
    }

    @Override
    @Operation(
            description = "this method get teachers data ",
            summary = "GET method and the method get teachers method",
            method = "GET MAPPING")
    @GetMapping(value = "/{id}")
    public ResponseDto<TeachersDto> get(@PathVariable(value = "id") Integer entityId) {
        return service.get(entityId);
    }

    @Override
    @Operation(
            description = "this method update teachers data and save to database",
            summary = "PUT method and the method update teachers data",
            method = "PUT MAPPING")
    @PutMapping(value = "/{id}")
    public ResponseDto<TeachersDto> update(@PathVariable(value = "id") Integer entityId,
                                           @RequestBody TeachersDto dto) {
        return service.update(entityId, dto);
    }

    @Override
    @Operation(
            description = "this method delete teachers data and remove from database",
            summary = "POST method and the method create teachers",
            method = "POST MAPPING")
    @DeleteMapping(value = "/{id}")
    public ResponseDto<TeachersDto> delete(@PathVariable(value = "id") Integer entityId) {
        return service.delete(entityId);
    }

    @Override
    @Operation(
            description = "this method getAll teachers data ",
            summary = "GET method and the method Get all teachers",
            method = "GET MAPPING")
    @GetMapping(value = "/getAll")
    public ResponseDto<List<TeachersDto>> getAll() {
        return service.getAll();
    }
}
