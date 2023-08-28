package com.company.TestErd.Service.Mapper;

import com.company.TestErd.Dto.SubjectsDto;
import com.company.TestErd.Module.Subjects;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class SubjectsMapper {

    public abstract SubjectsDto toDto(Subjects subjects);
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "deletedAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    public  abstract Subjects toEntity(SubjectsDto dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = Subjects.class)
    public abstract Subjects updateFromToDto(SubjectsDto dto, @MappingTarget Subjects subjects);

}
