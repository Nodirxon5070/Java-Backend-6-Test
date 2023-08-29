package com.company.TestErd.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class StudentsDto {
    private Integer studentId;
    private Integer groupId;
    private String firstname;
    private String lastname;
}
