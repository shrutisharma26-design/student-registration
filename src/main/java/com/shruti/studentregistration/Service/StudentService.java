package com.shruti.studentregistration.Service;


import com.shruti.studentregistration.DTO.StudentDTO;
import com.shruti.studentregistration.Model.Student;
import com.shruti.studentregistration.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    // Add Student
    public StudentDTO addStudent(StudentDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());
        student.setAge(dto.getAge());
        student.setCourses(dto.getCourses());

        Student savedStudent = studentRepository.save(student);

        return convertToDTO(savedStudent);
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return null;
        }
        return convertToDTO(student);
    }

    public List<StudentDTO> getAllStudent(){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(Student student : students){
            studentDTOList.add(convertToDTO(student));
        }
        return studentDTOList;
    }

    public StudentDTO updateStudent(Long id, StudentDTO dto){
        Student student = studentRepository.findById(id).orElse(null);
        if(student == null){
            return null;
        }
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());
        student.setAge(dto.getAge());
        student.setCourses(dto.getCourses());

        Student updatedStudent = studentRepository.save(student);
        return convertToDTO(updatedStudent);
    }

    public String deleteStudent(Long id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student == null){
            return "Student not found";
        }
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }


    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setPhone(student.getPhone());
        dto.setAge(student.getAge());
        dto.setCourses(student.getCourses());

        return dto;
    }
}

