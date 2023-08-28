package com.company.TestErd.Service.Mapper;

import com.company.TestErd.Dto.SubjectTeacherDto;
import com.company.TestErd.Module.SubjectTeacher;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-28T16:18:05+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class SubjectTeacherMapperImpl extends SubjectTeacherMapper {

    @Override
    public SubjectTeacherDto toDto(SubjectTeacher subTeacher) {
        if ( subTeacher == null ) {
            return null;
        }

        SubjectTeacherDto.SubjectTeacherDtoBuilder subjectTeacherDto = SubjectTeacherDto.builder();

        subjectTeacherDto.subjectId( subTeacher.getSubjectId() );
        subjectTeacherDto.teacherId( subTeacher.getTeacherId() );
        subjectTeacherDto.groupId( subTeacher.getGroupId() );
        subjectTeacherDto.createdAt( subTeacher.getCreatedAt() );
        subjectTeacherDto.updatedAt( subTeacher.getUpdatedAt() );
        subjectTeacherDto.deletedAt( subTeacher.getDeletedAt() );

        return subjectTeacherDto.build();
    }

    @Override
    public SubjectTeacher toEntity(SubjectTeacherDto dto) {
        if ( dto == null ) {
            return null;
        }

        SubjectTeacher.SubjectTeacherBuilder subjectTeacher = SubjectTeacher.builder();

        subjectTeacher.subjectId( dto.getSubjectId() );
        subjectTeacher.teacherId( dto.getTeacherId() );
        subjectTeacher.groupId( dto.getGroupId() );

        return subjectTeacher.build();
    }

    @Override
    public SubjectTeacher updateFromToDto(SubjectTeacherDto dto, SubjectTeacher subTeacher) {
        if ( dto == null ) {
            return subTeacher;
        }

        if ( dto.getSubjectId() != null ) {
            subTeacher.setSubjectId( dto.getSubjectId() );
        }
        if ( dto.getTeacherId() != null ) {
            subTeacher.setTeacherId( dto.getTeacherId() );
        }
        if ( dto.getGroupId() != null ) {
            subTeacher.setGroupId( dto.getGroupId() );
        }
        if ( dto.getCreatedAt() != null ) {
            subTeacher.setCreatedAt( dto.getCreatedAt() );
        }
        if ( dto.getUpdatedAt() != null ) {
            subTeacher.setUpdatedAt( dto.getUpdatedAt() );
        }
        if ( dto.getDeletedAt() != null ) {
            subTeacher.setDeletedAt( dto.getDeletedAt() );
        }

        return subTeacher;
    }
}
