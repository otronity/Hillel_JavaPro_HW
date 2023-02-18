package com.org.hibernate.repository;

import com.org.hibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class CustomStudentRepositoryImpl implements CustomStudentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createStudent(String name, String email){
        Query query = entityManager.createNativeQuery("insert into Student(name, email) " +
                " values (?1, ?2)", Student.class);
        query.setParameter(1, name);
        query.setParameter(2, email);
        query.executeUpdate();
    };

    @Override
    @Transactional
    public void deleteStudentById(Integer id){
        log.info("Deleting Student by Id " + id);
        Query query = entityManager.createNativeQuery(
                   "delete from Mark where id = ?1 ;\n" +
                      "delete from Student WHERE id = ?1  ;");
        query.setParameter(1, id);
        query.executeUpdate();
    };

    @Override
    @Transactional
    public void updateStudentEmail(Integer id, String email){
        log.info("Updating Student by Id " + id);
        Query query = entityManager.createNativeQuery("update Student set email = ?1" +
                " WHERE id = ?2", Student.class);
        query.setParameter(1, email);
        query.setParameter(2, id);
        query.executeUpdate();
    };

    @Override
    public List<Student> findAllStudents(){
        log.info("Find all Students");
        Query query = entityManager.createNativeQuery("select id, name, email from Student s", Student.class);
        return (List<Student>) query.getResultList();
    };

    @Override
    public Student findStudentById(Integer id){
        log.info("Find Student bi Id " + id);
        Query query = entityManager.createNativeQuery("select id, name, email from Student s " +
                " WHERE id = ?1", Student.class);
        query.setParameter(1, id);
        return (Student) query.getSingleResult();
    };
}
