package com.company.TestErd.Dto;

import com.company.TestErd.Module.Subjects;
import com.company.TestErd.Module.Teachers;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectTeacherDto {
    private Integer subTeachId;
    @NotNull(message = "the field is not filled")
    private Integer subjectId;
    @NotNull(message = "the field is not filled")
    private Integer teacherId;
    @NotNull(message = "the field is not filled")
    private Integer groupId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private Set<SubjectsDto> subSetDto;
    private Set<TeachersDto> teachSetDto;
}
