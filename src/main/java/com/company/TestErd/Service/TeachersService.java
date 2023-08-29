package com.company.TestErd.Service;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SimpleCrud;
import com.company.TestErd.Dto.TeachersDto;
import com.company.TestErd.Repository.TeacherRepository;
import com.company.TestErd.Service.Mapper.TeachersMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record TeachersService (
        TeachersMapper mapper,
        TeacherRepository repository)
        implements SimpleCrud<Integer, TeachersDto> {
    @Override
    public ResponseDto<TeachersDto> create(@Valid TeachersDto dto) {
        try {
            return ResponseDto.<TeachersDto>builder()
                    .message("OK")
                    .success(true)
                    .date(this.mapper.toDto(
                            this.repository.save(
                                    this.mapper.toEntity(dto))))
                    .build();

        } catch (Exception e) {
            return ResponseDto.<TeachersDto>builder()
                    .code(-2)
                    .message(String.format("teacher save while error :: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<TeachersDto> get(Integer entityId) {
        return this.repository.findByTeacherId(entityId)
                .map(subjects ->
                        ResponseDto.<TeachersDto>builder()
                                .message("OK")
                                .success(true)
                                .date(this.mapper.toDtoWithSubTeach(subjects))
                                .build()
                ).orElse(
                        ResponseDto.<TeachersDto>builder()
                                .code(-1)
                                .message(String.format("No teacher found for this %d id", entityId))
                                .build()
                );
    }

    @Override
    public ResponseDto<TeachersDto> update(Integer entityId, TeachersDto dto) {
        try {
            return this.repository.findByTeacherId(entityId).map(
                            subjects ->
                                    ResponseDto.<TeachersDto>builder()
                                            .message("OK")
                                            .success(true)
                                            .date(this.mapper.toDtoWithSubTeach(
                                                    this.repository.save(
                                                            this.mapper.updateFromToDto(dto, subjects))))
                                            .build()
                    )
                    .orElse(ResponseDto.<TeachersDto>builder()
                            .code(-1)
                            .message(String.format("No teacher found for this %d id", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<TeachersDto>builder()
                    .code(-2)
                    .message(String.format("teacher update while error %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<TeachersDto> delete(Integer entityId) {
        try {
            return this.repository.findByTeacherId(entityId).map(
                            subjects -> {
                                this.repository.delete(subjects);
                                return ResponseDto.<TeachersDto>builder()
                                        .message("OK")
                                        .success(true)
                                        .date(this.mapper.toDto(
                                                this.repository.save(subjects)))
                                        .build();
                            }
                    )
                    .orElse(ResponseDto.<TeachersDto>builder()
                            .code(-1)
                            .message(String.format("No teacher found for this %d id", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<TeachersDto>builder()
                    .code(-2)
                    .message(String.format("teacher delete while error %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<List<TeachersDto>> getAll() {
        return Optional.of(this.repository.findAll().stream().map(this.mapper::toDto).toList())
                .map(
                        teachersDtos ->
                                ResponseDto.<List<TeachersDto>>builder()
                                        .message("OK")
                                        .success(true)
                                        .date(teachersDtos)
                                        .build()
                )
                .orElse(
                        ResponseDto.<List<TeachersDto>>builder()
                                .code(-1)
                                .message("teachers are not found")
                                .build()

                );
    }
}
