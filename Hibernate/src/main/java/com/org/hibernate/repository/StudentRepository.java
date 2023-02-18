package com.org.hibernate.repository;

import com.org.hibernate.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, CustomStudentRepository {


}
