package com.company.TestErd.Service;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SimpleCrud;
import com.company.TestErd.Dto.SubjectTeacherDto;
import com.company.TestErd.Service.Mapper.SubjectTeacherMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record SubjectTeacherService(
        SubjectTeacherMapper mapper)
        implements SimpleCrud<Integer, SubjectTeacherDto> {
    @Override
    public ResponseDto<SubjectTeacherDto> create(SubjectTeacherDto dto) {
        return null;
    }

    @Override
    public ResponseDto<SubjectTeacherDto> get(Integer entityId) {
        return null;
    }

    @Override
    public ResponseDto<SubjectTeacherDto> update(Integer entityId, SubjectTeacherDto dto) {
        return null;
    }

    @Override
    public ResponseDto<SubjectTeacherDto> delete(Integer entityId) {
        return null;
    }

    @Override
    public ResponseDto<List<SubjectTeacherDto>> getAll() {
        return null;
    }
}
