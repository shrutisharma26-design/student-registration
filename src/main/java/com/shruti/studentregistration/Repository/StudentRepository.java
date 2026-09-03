package com.shruti.studentregistration.Repository;

import com.shruti.studentregistration.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface StudentRepository extends JpaRepository<Student, Long>{

    }

