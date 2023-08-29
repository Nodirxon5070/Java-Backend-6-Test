package com.company.TestErd.Service.Mapper;

import com.company.TestErd.Dto.SubjectsDto;
import com.company.TestErd.Module.Subjects;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)

public abstract class SubjectsMapper {
    @Autowired
    SubjectTeacherMapper mapper;

    @Mapping(target = "subTeachDto",ignore = true)
    @Mapping(target = "marksDtoSet",ignore = true)
    public abstract SubjectsDto toDto(Subjects subjects);
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "deletedAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    public  abstract Subjects toEntity(SubjectsDto dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = Subjects.class)
    public abstract Subjects updateFromToDto(SubjectsDto dto, @MappingTarget Subjects subjects);

    @Mapping(target = "subTeachDto",expression = "java(mapper.toDto(subjects.getSubjectTeacher()))")
    public abstract SubjectsDto toDtoWithSubTeach(Subjects subjects);

}
