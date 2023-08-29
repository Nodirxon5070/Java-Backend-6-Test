package com.company.TestErd.Dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T>{
    private int code;
    private boolean success;
    private String message;
    private T date;
    private List<ErrorDto> errorlist;
}
