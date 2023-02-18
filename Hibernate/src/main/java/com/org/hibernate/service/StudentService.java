package com.org.hibernate.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.hibernate.dto.MarkDto;
import com.org.hibernate.dto.StudentDto;
import com.org.hibernate.model.Mark;
import com.org.hibernate.model.Student;
import com.org.hibernate.repository.MarkRepository;
import com.org.hibernate.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;
    private final ObjectMapper objectMapper;


    public StudentDto createStudent(StudentDto studentDto) {
        Student student = objectMapper.convertValue(studentDto, Student.class);
        studentRepository.save(student);
        studentDto.setId(student.getId());

        List<MarkDto> marksdto = studentDto.getMarks();
        for (MarkDto markDto : marksdto) {
            Mark mark = objectMapper.convertValue(markDto, Mark.class);
            mark.setStudent(student);
            markRepository.save(mark);
        }
        return studentDto;
    }

    @Transactional
    public void deleteStudentById(Integer id){
        studentRepository.deleteStudentById(id);
    }

    @Transactional
    public void updateStudentEmail(Integer id, String newemail){
        studentRepository.updateStudentEmail(id, newemail);
    }

    public List<Student> findAll(){
        return studentRepository.findAllStudents();
    }

    public Student findStudentById(Integer id){
        return studentRepository.findStudentById(id);
    }

    public String printStudent(Student student){
        String s = "Id = " + student.getId() + "\t" +
                    "Name = " + student.getName() + "\t" +
                    "Email = " + student.getEmail();
        return s;
    }
    public String printStudentList(List<Student> student){
        StringBuilder sb = new StringBuilder();
        sb.append("\nId\tName\tEmail\n");
        for (Student st : student) {
            sb.append(st.getId() + "\t");
            sb.append(st.getName() + "\t");
            sb.append(st.getEmail() + "\t");
            sb.append("\n");
        }
        String s = sb.toString();
        return s;
    }
}
