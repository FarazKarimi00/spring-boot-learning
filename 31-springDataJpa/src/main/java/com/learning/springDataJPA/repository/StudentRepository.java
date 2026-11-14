package com.learning.springDataJPA.repository;

import com.learning.springDataJPA.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    void save(Student student);
//    Optional<Student> findById(Long id);

    @Query(value = """
            SELECT * FROM student
            WHERE email = :email
            """, nativeQuery = true)
    Optional<Student> findByEmail(@Param("email") String email);
    List<Student> findByName(String name, Sort sort);
}
