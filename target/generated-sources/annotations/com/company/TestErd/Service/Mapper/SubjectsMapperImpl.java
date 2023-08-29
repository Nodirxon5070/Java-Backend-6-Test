package com.company.TestErd.Service.Mapper;

import com.company.TestErd.Dto.SubjectsDto;
import com.company.TestErd.Module.Subjects;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-29T10:03:37+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class SubjectsMapperImpl extends SubjectsMapper {

    @Override
    public SubjectsDto toDto(Subjects subjects) {
        if ( subjects == null ) {
            return null;
        }

        SubjectsDto.SubjectsDtoBuilder subjectsDto = SubjectsDto.builder();

        subjectsDto.subjectId( subjects.getSubjectId() );
        subjectsDto.title( subjects.getTitle() );
        subjectsDto.createdAt( subjects.getCreatedAt() );
        subjectsDto.updatedAt( subjects.getUpdatedAt() );
        subjectsDto.deletedAt( subjects.getDeletedAt() );

        return subjectsDto.build();
    }

    @Override
    public Subjects toEntity(SubjectsDto dto) {
        if ( dto == null ) {
            return null;
        }

        Subjects.SubjectsBuilder subjects = Subjects.builder();

        subjects.subjectId( dto.getSubjectId() );
        subjects.title( dto.getTitle() );

        return subjects.build();
    }

    @Override
    public Subjects updateFromToDto(SubjectsDto dto, Subjects subjects) {
        if ( dto == null ) {
            return subjects;
        }

        if ( dto.getSubjectId() != null ) {
            subjects.setSubjectId( dto.getSubjectId() );
        }
        if ( dto.getTitle() != null ) {
            subjects.setTitle( dto.getTitle() );
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
    public SubjectsDto toDtoWithSubTeach(Subjects subjects) {
        if ( subjects == null ) {
            return null;
        }

        SubjectsDto.SubjectsDtoBuilder subjectsDto = SubjectsDto.builder();

        subjectsDto.subjectId( subjects.getSubjectId() );
        subjectsDto.title( subjects.getTitle() );
        subjectsDto.createdAt( subjects.getCreatedAt() );
        subjectsDto.updatedAt( subjects.getUpdatedAt() );
        subjectsDto.deletedAt( subjects.getDeletedAt() );

        subjectsDto.subTeachDto( mapper.toDto(subjects.getSubjectTeacher()) );

        return subjectsDto.build();
    }
}
