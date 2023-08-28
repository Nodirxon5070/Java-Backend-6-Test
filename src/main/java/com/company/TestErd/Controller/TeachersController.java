package com.company.TestErd.Controller;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SimpleCrud;
import com.company.TestErd.Dto.TeachersDto;
import com.company.TestErd.Service.TeachersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "teacher")
public class TeachersController implements SimpleCrud<Integer, TeachersDto> {
    private final TeachersService service;

    @Override
    @PostMapping
    public ResponseDto<TeachersDto> create(@RequestBody TeachersDto dto) {
        return service.create(dto);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseDto<TeachersDto> get(@PathVariable(value = "id") Integer entityId) {
        return service.get(entityId);
    }

    @Override
    @PutMapping(value = "/{id}")
    public ResponseDto<TeachersDto> update(@PathVariable(value = "id")Integer entityId,
                                           @RequestBody   TeachersDto dto) {
        return service.update(entityId, dto);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseDto<TeachersDto> delete(@PathVariable(value = "id")Integer entityId) {
        return service.delete(entityId);
    }

    @Override
    @GetMapping(value = "getAll")
    public ResponseDto<List<TeachersDto>> getAll() {
        return service.getAll();
    }
}
