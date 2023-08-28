package com.company.TestErd.Repository;

import com.company.TestErd.Module.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subjects,Integer> {
    Optional<Subjects> findBySubjectId(Integer subjectId);


    @Query(value = "select * from subject ",nativeQuery = true)
    List<Subjects> findAll();
}
