package com.company.finalyexam.repo;


import com.company.finalyexam.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
