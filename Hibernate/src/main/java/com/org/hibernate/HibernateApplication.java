package com.org.hibernate;

import com.org.hibernate.dto.MarkDto;
import com.org.hibernate.dto.StudentDto;
import com.org.hibernate.model.Student;
import com.org.hibernate.repository.StudentRepository;
import com.org.hibernate.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class HibernateApplication {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        List<MarkDto> lm = new ArrayList<>();
        lm.add(new MarkDto("math", 5));
        lm.add(new MarkDto("physics", 4));
        var dto = new StudentDto(null, "Olga", "Olga@gmail.com", lm);
        studentService.createStudent(dto);

        lm = new ArrayList<>();
        lm.add(new MarkDto("math", 4));
        lm.add(new MarkDto("physics", 4));
        dto = new StudentDto(null, "Pavlo", "Pavlo@gmail.com", lm);
        studentService.createStudent(dto);

        lm = new ArrayList<>();
        lm.add(new MarkDto("chemistry", 4));
        lm.add(new MarkDto("physics", 3));
        dto = new StudentDto(null, "Nikita", "Nikita@gmail.com", lm);
        studentService.createStudent(dto);

        studentService.updateStudentEmail(2, "newEmail@gmail.com");
        Student student = studentService.findStudentById(2);
        log.info("updating email for student : {}", studentService.printStudent(student));
        List<Student> sl = studentService.findAll();
        log.info("all students: {}", studentService.printStudentList(sl));
        Student student1 = studentService.findStudentById(3);
        log.info("student by id 3 : {}", studentService.printStudent(student1));
        log.info("deleting student");
        studentService.deleteStudentById(1);
        sl = studentService.findAll();
        log.info("all students {}", studentService.printStudentList(sl));

    }
}
