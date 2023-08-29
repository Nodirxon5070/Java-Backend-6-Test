package com.company.TestErd.Service.Mapper;

import com.company.TestErd.Dto.SubjectTeacherDto;
import com.company.TestErd.Dto.SubjectsDto;
import com.company.TestErd.Module.SubjectTeacher;
import com.company.TestErd.Module.Subjects;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class SubjectTeacherMapper {
    @Autowired
    @Lazy
    SubjectsMapper subjectsMapper;
    @Autowired
    @Lazy
    TeachersMapper teachersMapper;

    @Mapping(target = "subSetDto", ignore = true)
    @Mapping(target = "teachSetDto", ignore = true)
    public abstract SubjectTeacherDto toDto(SubjectTeacher subTeacher);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    public abstract SubjectTeacher toEntity(SubjectTeacherDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = SubjectTeacher.class)
    public abstract SubjectTeacher updateFromToDto(SubjectTeacherDto dto, @MappingTarget SubjectTeacher subTeacher);


    @Mapping(target = "subSetDto", expression = "java(subjectTeacher.getSubjects().stream().map(subjectsMapper::toDto).collect(Collectors.toSet()))")
    @Mapping(target = "teachSetDto", expression = "java(subjectTeacher.getTeachers().stream().map(teachersMapper::toDto).collect(Collectors.toSet()))")
    public abstract SubjectTeacherDto toDtoWithSubjectAndGroupAndTeacher(SubjectTeacher subjectTeacher);


}
