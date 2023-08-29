package com.company.TestErd.Controller;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SimpleCrud;
import com.company.TestErd.Dto.SubjectsDto;
import com.company.TestErd.Service.SubjectsService;
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
    @PostMapping
    public ResponseDto<SubjectsDto> create(@RequestBody SubjectsDto dto) {
        return service.create(dto);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseDto<SubjectsDto> get(@PathVariable(value = "id") Integer entityId) {
        return service.get(entityId);
    }

    @Override
    @PutMapping(value = "/{id}")
    public ResponseDto<SubjectsDto> update(@PathVariable(value = "id")Integer entityId,
                                        @RequestBody   SubjectsDto dto) {
        return service.update(entityId, dto);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseDto<SubjectsDto> delete(@PathVariable(value = "id")Integer entityId) {
        return service.delete(entityId);
    }

    @Override
    @GetMapping(value = "getAll")
    public ResponseDto<List<SubjectsDto>> getAll() {
        return service.getAll();
    }
}
