package com.company.TestErd.Controller;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SimpleCrud;
import com.company.TestErd.Dto.SubjectTeacherDto;
import com.company.TestErd.Service.SubjectTeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "sub_teach")
public class SubjectTeacherController implements SimpleCrud<Integer, SubjectTeacherDto> {
    private final SubjectTeacherService service;
    @Override
    @PostMapping
    public ResponseDto<SubjectTeacherDto> create(@RequestBody SubjectTeacherDto dto) {
        return service.create(dto);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseDto<SubjectTeacherDto> get(@PathVariable(value = "id") Integer entityId) {
        return service.get(entityId);
    }

    @Override
    @PutMapping(value = "/{id}")
    public ResponseDto<SubjectTeacherDto> update(@PathVariable(value = "id")Integer entityId,
                                           @RequestBody   SubjectTeacherDto dto) {
        return service.update(entityId, dto);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseDto<SubjectTeacherDto> delete(@PathVariable(value = "id")Integer entityId) {
        return service.delete(entityId);
    }

    @Override
    @GetMapping
    public ResponseDto<List<SubjectTeacherDto>> getAll() {
        return service.getAll();
    }
}
