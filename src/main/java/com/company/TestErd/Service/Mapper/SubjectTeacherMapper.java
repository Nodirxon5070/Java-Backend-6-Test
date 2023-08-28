package com.company.TestErd.Service.Mapper;

import com.company.TestErd.Dto.SubjectTeacherDto;
import com.company.TestErd.Dto.SubjectsDto;
import com.company.TestErd.Module.SubjectTeacher;
import com.company.TestErd.Module.Subjects;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class SubjectTeacherMapper {
    public abstract SubjectTeacherDto toDto(SubjectTeacher subTeacher);
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "deletedAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    public  abstract SubjectTeacher toEntity(SubjectTeacherDto dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = SubjectTeacher.class)
    public abstract SubjectTeacher updateFromToDto(SubjectTeacherDto dto, @MappingTarget SubjectTeacher subTeacher);

}
