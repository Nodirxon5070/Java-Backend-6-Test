package com.company.TestErd.Service.Mapper;

import com.company.TestErd.Dto.SubjectsDto;
import com.company.TestErd.Dto.TeachersDto;
import com.company.TestErd.Module.Subjects;
import com.company.TestErd.Module.Teachers;
import org.mapstruct.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class TeachersMapper {

    public abstract TeachersDto toDto(Teachers subjects);
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "deletedAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    public  abstract Teachers toEntity(TeachersDto dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = Teachers.class)
    public abstract Teachers updateFromToDto(TeachersDto dto, @MappingTarget Teachers subjects);

}
