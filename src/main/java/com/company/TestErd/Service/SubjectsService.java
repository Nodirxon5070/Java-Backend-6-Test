package com.company.TestErd.Service;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SimpleCrud;
import com.company.TestErd.Dto.SubjectsDto;
import org.springframework.stereotype.Service;
import com.company.TestErd.Repository.SubjectRepository;
import com.company.TestErd.Service.Mapper.SubjectsMapper;

import java.util.List;
import java.util.Optional;

@Service
public record SubjectsService(
        SubjectsMapper mapper,
        SubjectRepository repository)
        implements SimpleCrud<Integer, SubjectsDto> {
    @Override
    public ResponseDto<SubjectsDto> create(SubjectsDto dto) {
        try {
            return ResponseDto.<SubjectsDto>builder()
                    .message("OK")
                    .success(true)
                    .date(this.mapper.toDto(
                            this.repository.save(
                                    this.mapper.toEntity(dto))))
                    .build();

        } catch (Exception e) {
            return ResponseDto.<SubjectsDto>builder()
                    .code(-2)
                    .message(String.format("subject save while error :: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<SubjectsDto> get(Integer entityId) {
        return this.repository.findBySubjectId(entityId)
                .map(subjects ->
                        ResponseDto.<SubjectsDto>builder()
                                .message("OK")
                                .success(true)
                                .date(this.mapper.toDtoWithSubTeach(subjects))
                                .build()
                ).orElse(
                        ResponseDto.<SubjectsDto>builder()
                                .code(-1)
                                .message(String.format("No user found for this %d id", entityId))
                                .build()
                );
    }

    @Override
    public ResponseDto<SubjectsDto> update(Integer entityId, SubjectsDto dto) {
        try {
            return this.repository.findBySubjectId(entityId).map(
                            subjects ->
                                    ResponseDto.<SubjectsDto>builder()
                                            .message("OK")
                                            .success(true)
                                            .date(this.mapper.toDto(
                                                    this.repository.save(
                                                            this.mapper.updateFromToDto(dto, subjects))))
                                            .build()
                    )
                    .orElse(ResponseDto.<SubjectsDto>builder()
                            .code(-1)
                            .message(String.format("No user found for this %d id", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<SubjectsDto>builder()
                    .code(-2)
                    .message(String.format("subject update while error %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<SubjectsDto> delete(Integer entityId) {
        try {
            return this.repository.findBySubjectId(entityId).map(
                            subjects -> {
                                this.repository.delete(subjects);
                                return ResponseDto.<SubjectsDto>builder()
                                        .message("OK")
                                        .success(true)
                                        .date(this.mapper.toDto(
                                                this.repository.save(subjects)))
                                        .build();
                            }
                    )
                    .orElse(ResponseDto.<SubjectsDto>builder()
                            .code(-1)
                            .message(String.format("No user found for this %d id", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<SubjectsDto>builder()
                    .code(-2)
                    .message(String.format("subject delete while error %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<List<SubjectsDto>> getAll() {
        return Optional.of(this.repository.findAll().stream().map(this.mapper::toDto).toList())
                .map(
                        subjectsDtoStream ->
                                ResponseDto.<List<SubjectsDto>>builder()
                                        .message("OK")
                                        .success(true)
                                        .date(subjectsDtoStream)
                                        .build()
                )
                .orElse(
                        ResponseDto.<List<SubjectsDto>>builder()
                                .code(-1)
                                .message("subjects are not found")
                                .build()

                );
    }
}
