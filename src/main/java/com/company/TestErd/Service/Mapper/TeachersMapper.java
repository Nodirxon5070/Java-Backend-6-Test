package com.company.TestErd.Service.Mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public class TeachersMapper {
}
