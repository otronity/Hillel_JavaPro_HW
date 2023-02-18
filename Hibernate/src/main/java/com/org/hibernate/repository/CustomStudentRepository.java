package com.org.hibernate.repository;

import com.org.hibernate.model.Student;
import java.util.List;

public interface CustomStudentRepository {

    void createStudent(String name, String email);
    void deleteStudentById(Integer id);
    void updateStudentEmail(Integer id, String email);
    List<Student> findAllStudents();
    Student findStudentById(Integer id);
}
