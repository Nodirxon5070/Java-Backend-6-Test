package com.company.TestErd.Service;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SimpleCrud;
import com.company.TestErd.Dto.SubjectTeacherDto;
import com.company.TestErd.Repository.SubjectTeacherRepository;
import com.company.TestErd.Service.Mapper.SubjectTeacherMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record SubjectTeacherService(
        SubjectTeacherMapper mapper,
        SubjectTeacherRepository repository,
        SubjectsService subjectsService,
        TeachersService teachersService,
        MarksService marksService)

        implements SimpleCrud<Integer, SubjectTeacherDto> {
    @Override
    public ResponseDto<SubjectTeacherDto> create(SubjectTeacherDto dto) {
        try {
            if (subjectsService.get(dto.getSubjectId()).getDate()==null){
                return ResponseDto.<SubjectTeacherDto>builder()
                        .code(-1)
                        .message("subject do not exist")
                        .build();
            }
            if (teachersService.get(dto.getTeacherId()).getDate()==null){
                return ResponseDto.<SubjectTeacherDto>builder()
                        .code(-1)
                        .message("teacher do not exist")
                        .build();
            }
            return ResponseDto.<SubjectTeacherDto>builder()
                    .message("OK")
                    .success(true)
                    .date(this.mapper.toDtoWithSubjectAndGroupAndTeacher(
                            this.repository.save(
                                    this.mapper.toEntity(dto))))
                    .build();

        } catch (Exception e) {
            return ResponseDto.<SubjectTeacherDto>builder()
                    .code(-2)
                    .message(String.format("subject save while error :: %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<SubjectTeacherDto> get(Integer entityId) {
        return this.repository.findBySubTeachId(entityId)
                .map(subjects ->
                        ResponseDto.<SubjectTeacherDto>builder()
                                .message("OK")
                                .success(true)
                                .date(this.mapper.toDtoWithSubjectAndGroupAndTeacher(subjects))
                                .build()
                ).orElse(
                        ResponseDto.<SubjectTeacherDto>builder()
                                .code(-1)
                                .message(String.format("No subjectTeacher found for this %d id", entityId))
                                .build()
                );
    }

    @Override
    public ResponseDto<SubjectTeacherDto> update(Integer entityId, SubjectTeacherDto dto) {
        try {
            return this.repository.findBySubTeachId(entityId).map(
                            subjects ->
                                    ResponseDto.<SubjectTeacherDto>builder()
                                            .message("OK")
                                            .success(true)
                                            .date(this.mapper.toDtoWithSubjectAndGroupAndTeacher(
                                                    this.repository.save(
                                                            this.mapper.updateFromToDto(dto, subjects))))
                                            .build()
                    )
                    .orElse(ResponseDto.<SubjectTeacherDto>builder()
                            .code(-1)
                            .message(String.format("No subjectTeacher found for this %d id", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<SubjectTeacherDto>builder()
                    .code(-2)
                    .message(String.format("subjectTeacher update while error %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<SubjectTeacherDto> delete(Integer entityId) {
        try {
            return this.repository.findBySubTeachId(entityId).map(
                            subjects -> {
                                this.repository.delete(subjects);
                                return ResponseDto.<SubjectTeacherDto>builder()
                                        .message("OK")
                                        .success(true)
                                        .date(this.mapper.toDtoWithSubjectAndGroupAndTeacher(
                                                this.repository.save(subjects)))
                                        .build();
                            }
                    )
                    .orElse(ResponseDto.<SubjectTeacherDto>builder()
                            .code(-1)
                            .message(String.format("No subjectTeacher found for this %d id", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<SubjectTeacherDto>builder()
                    .code(-2)
                    .message(String.format("subject teacher delete while error %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<List<SubjectTeacherDto>> getAll() {
        return Optional.of(this.repository.findAll().stream().map(this.mapper::toDtoWithSubjectAndGroupAndTeacher).toList())
                .map(
                        subjectTeacherDtos ->
                                ResponseDto.<List<SubjectTeacherDto>>builder()
                                        .message("OK")
                                        .success(true)
                                        .date(subjectTeacherDtos)
                                        .build()
                )
                .orElse(
                        ResponseDto.<List<SubjectTeacherDto>>builder()
                                .code(-1)
                                .message("subjectTeachers are not found")
                                .build()
                );
    }
}
