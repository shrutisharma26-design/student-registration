package com.shruti.studentregistration.Controller;


import com.shruti.studentregistration.DTO.StudentDTO;
import com.shruti.studentregistration.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO dto){
        StudentDTO student = studentService.addStudent(dto);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        StudentDTO student = studentService.getStudentById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> students = studentService.getAllStudent();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudents(
            @PathVariable Long id,
            @Valid @RequestBody StudentDTO dto){
        StudentDTO student = studentService.updateStudent(id,dto);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        String message = studentService.deleteStudent(id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
