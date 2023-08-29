package com.company.TestErd.Service.Mapper;

import com.company.TestErd.Dto.TeachersDto;
import com.company.TestErd.Module.Teachers;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-29T10:15:15+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class TeachersMapperImpl extends TeachersMapper {

    @Override
    public TeachersDto toDto(Teachers subjects) {
        if ( subjects == null ) {
            return null;
        }

        TeachersDto.TeachersDtoBuilder teachersDto = TeachersDto.builder();

        teachersDto.teacherId( subjects.getTeacherId() );
        teachersDto.firstname( subjects.getFirstname() );
        teachersDto.lastname( subjects.getLastname() );
        teachersDto.createdAt( subjects.getCreatedAt() );
        teachersDto.updatedAt( subjects.getUpdatedAt() );
        teachersDto.deletedAt( subjects.getDeletedAt() );

        return teachersDto.build();
    }

    @Override
    public Teachers toEntity(TeachersDto dto) {
        if ( dto == null ) {
            return null;
        }

        Teachers.TeachersBuilder teachers = Teachers.builder();

        teachers.teacherId( dto.getTeacherId() );
        teachers.firstname( dto.getFirstname() );
        teachers.lastname( dto.getLastname() );

        return teachers.build();
    }

    @Override
    public Teachers updateFromToDto(TeachersDto dto, Teachers subjects) {
        if ( dto == null ) {
            return subjects;
        }

        if ( dto.getTeacherId() != null ) {
            subjects.setTeacherId( dto.getTeacherId() );
        }
        if ( dto.getFirstname() != null ) {
            subjects.setFirstname( dto.getFirstname() );
        }
        if ( dto.getLastname() != null ) {
            subjects.setLastname( dto.getLastname() );
        }
        if ( dto.getCreatedAt() != null ) {
            subjects.setCreatedAt( dto.getCreatedAt() );
        }
        if ( dto.getUpdatedAt() != null ) {
            subjects.setUpdatedAt( dto.getUpdatedAt() );
        }
        if ( dto.getDeletedAt() != null ) {
            subjects.setDeletedAt( dto.getDeletedAt() );
        }

        return subjects;
    }

    @Override
    public TeachersDto toDtoWithSubTeach(Teachers teachers) {
        if ( teachers == null ) {
            return null;
        }

        TeachersDto.TeachersDtoBuilder teachersDto = TeachersDto.builder();

        teachersDto.teacherId( teachers.getTeacherId() );
        teachersDto.firstname( teachers.getFirstname() );
        teachersDto.lastname( teachers.getLastname() );
        teachersDto.createdAt( teachers.getCreatedAt() );
        teachersDto.updatedAt( teachers.getUpdatedAt() );
        teachersDto.deletedAt( teachers.getDeletedAt() );

        teachersDto.subTeachDto( mapper.toDto(teachers.getSubjectTeacher()) );

        return teachersDto.build();
    }
}
