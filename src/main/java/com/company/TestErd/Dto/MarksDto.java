package com.company.TestErd.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MarksDto {
    private Integer markId;
    private Integer studentId;
    private Integer subjectId;
    private Integer mark;
    private LocalDateTime date;
}
