package com.company.TestErd.Repository;


import com.company.TestErd.Module.SubjectTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectTeacherRepository extends JpaRepository<SubjectTeacher,Integer> {
    Optional<SubjectTeacher> findBySubTeachId(Integer subTeachId);

    @Query(value = "select * from subject_teacher ",nativeQuery = true)
    List<SubjectTeacher> findAll();

}
