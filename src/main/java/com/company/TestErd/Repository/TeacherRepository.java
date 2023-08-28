package com.company.TestErd.Repository;

import com.company.TestErd.Module.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teachers,Integer> {
    @Query(value = "select * from teachers",nativeQuery = true)
    List<Teachers> findAll();

    Optional<Teachers> findByTeacherId(Integer teacherId);
}
