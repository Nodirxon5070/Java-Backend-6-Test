package com.company.TestErd.Service;

import com.company.TestErd.Dto.ResponseDto;
import com.company.TestErd.Dto.SubjectsDto;
import com.company.TestErd.Module.Subjects;
import com.company.TestErd.Repository.SubjectRepository;
import com.company.TestErd.Service.Mapper.SubjectsMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SubjectsServiceTest {
    private SubjectsService service;
    private SubjectsMapper mapper;
    private SubjectRepository repository;

    @BeforeEach
    public void unit() {
        repository = mock(SubjectRepository.class);
        mapper = mock(SubjectsMapper.class);
        service = new SubjectsService(mapper, repository);
    }

    @Test
    void testCreatePositive() {
        when(this.mapper.toEntity(any())).thenReturn(
                Subjects.builder()
                        .title("title")
                        .subjectId(1)
                        .build());

        when(this.mapper.toDto(any())).thenReturn(SubjectsDto.builder()
                .subjectId(1)
                .title("tiy")
                .build());

        ResponseDto<SubjectsDto> response = service.create(any());

        assertEquals(response.getCode(), 0);
        assertEquals(response.getMessage(), "OK");
        assertNotNull(response.getDate());
        assertTrue(response.isSuccess());
        assertNull(response.getErrorlist());
        verify(this.mapper, times(1)).toEntity(any());
        verify(this.mapper, times(1)).toDto(any());

    }


    @Test
    void testCreateException() {
        when(this.mapper.toEntity(any())).thenThrow(RuntimeException.class);


        ResponseDto<SubjectsDto> response = service.create(any());

        assertEquals(response.getCode(), -2);
        assertNull(response.getDate());
        assertFalse(response.isSuccess());
        verify(this.mapper, times(1)).toEntity(any());

    }


    @Test
    void testGetPositive() {
        when(this.repository.findBySubjectId(any())).thenReturn(
                Optional.of(Subjects
                        .builder()
                        .subjectId(1)
                        .build()));


        when(this.mapper.toDtoWithSubTeach(any())).thenReturn(SubjectsDto.builder()

                .subjectId(1)
                .title("title")
                .build());

        ResponseDto<SubjectsDto> response = service.get(any());

        assertEquals(response.getCode(), 0);
        assertEquals(response.getMessage(), "OK");
        assertNotNull(response.getDate());
        assertTrue(response.isSuccess());
        assertNull(response.getErrorlist());
        verify(this.repository, times(1)).findBySubjectId(any());
        verify(this.mapper, times(1)).toDtoWithSubTeach(any());

    }

    @Test
    void testGetNegative() {


        when(this.repository.findBySubjectId(any())).thenReturn(Optional.empty());
        ResponseDto<SubjectsDto> response = service.get(any());

        assertEquals(response.getCode(), -1);
        assertNull(response.getDate());
        assertFalse(response.isSuccess());
        verify(this.repository, times(1)).findBySubjectId(any());

    }


    @Test
    void testUpdatePositive() {

        when(this.repository.findBySubjectId(any())).thenReturn(
                Optional.of(Subjects
                        .builder()
                        .subjectId(1)
                        .build()));

        when(this.mapper.toDto(any())).thenReturn(SubjectsDto.builder()
                .subjectId(1)
                .title("tiy")
                .build());

        when(this.mapper.updateFromToDto(any(), any())).thenReturn(Subjects.builder().build());

        ResponseDto<SubjectsDto> response = service.update(1, any());

        assertEquals(response.getCode(), 0);
        assertEquals(response.getMessage(), "OK");
        assertNotNull(response.getDate());
        assertTrue(response.isSuccess());
        assertNull(response.getErrorlist());
        verify(this.mapper, times(1)).updateFromToDto(any(), any());
        verify(this.mapper, times(1)).toDto(any());
        verify(this.repository, times(1)).findBySubjectId(any());

    }

}