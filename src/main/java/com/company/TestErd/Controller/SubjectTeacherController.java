package com.company.TestErd.Controller;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SimpleCrud;
import com.company.TestErd.Dto.SubjectTeacherDto;
import com.company.TestErd.Service.SubjectTeacherService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "sub_teach")
public class SubjectTeacherController implements SimpleCrud<Integer, SubjectTeacherDto> {
    private final SubjectTeacherService service;
    @Override
    @Operation(
            description = "this method create SubjectTeacher data and save to database",
            summary = "POST method and the method create SubjectTeacherTeacher data",
            method = "POST MAPPING")
    @PostMapping
    public ResponseDto<SubjectTeacherDto> create(@RequestBody SubjectTeacherDto dto) {
        return service.create(dto);
    }

    @Override
    @Operation(
            description = "this method get SubjectTeacher data ",
            summary = "GET method and the method get SubjectTeacher method",
            method = "GET MAPPING")
    @GetMapping(value = "/{id}")
    public ResponseDto<SubjectTeacherDto> get(@PathVariable(value = "id") Integer entityId) {
        return service.get(entityId);
    }

    @Override
    @Operation(
            description = "this method update SubjectTeacher data and save to database",
            summary = "PUT method and the method update SubjectTeacher",
            method = "PUT MAPPING")
    @PutMapping(value = "/{id}")
    public ResponseDto<SubjectTeacherDto> update(@PathVariable(value = "id") Integer entityId,
                                           @RequestBody SubjectTeacherDto dto) {
        return service.update(entityId, dto);
    }

    @Override
    @Operation(
            description = "this method delete SubjectTeacher data and remove from database",
            summary = "POST method and the method create SubjectTeacher",
            method = "POST MAPPING")
    @DeleteMapping(value = "/{id}")
    public ResponseDto<SubjectTeacherDto> delete(@PathVariable(value = "id") Integer entityId) {
        return service.delete(entityId);
    }

    @Override
    @Operation(
            description = "this method getAll SubjectTeacher data ",
            summary = "GET method and the method Get all SubjectTeacher",
            method = "GET MAPPING")
    @GetMapping(value = "/getAll")
    public ResponseDto<List<SubjectTeacherDto>> getAll() {
        return service.getAll();
    }
}
