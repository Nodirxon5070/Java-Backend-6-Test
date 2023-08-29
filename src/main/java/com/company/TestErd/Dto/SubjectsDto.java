package com.company.TestErd.Dto;

import com.company.TestErd.Module.Marks;
import com.company.TestErd.Module.SubjectTeacher;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectsDto {
    private Integer subjectId;
    @NotBlank(message = "the field is not filled")
    private String title;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private Set<MarksDto> marksDtoSet;
    private SubjectTeacherDto subTeachDto;
}
