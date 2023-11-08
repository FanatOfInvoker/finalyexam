package com.company.finalyexam.service;

import com.company.finalyexam.dto.StudentDto;
import com.company.finalyexam.entity.Gruh;
import com.company.finalyexam.entity.Student;
import com.company.finalyexam.entity.Teacher;
import com.company.finalyexam.repo.GruhRepository;
import com.company.finalyexam.repo.StudentRepository;
import com.company.finalyexam.repo.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepositoryrepository;
    private final TeacherRepository teacherRepositoryrepository;
    private final GruhRepository gruhRepository;


    public StudentDto creatStudent(StudentDto dto){
        Student student = mapToEntity(dto);
        studentRepositoryrepository.save(student);
        return dto;
    }
    public Boolean delete(Long id){
        Student student = studentRepositoryrepository.findById(id).orElse(null);
        if (student != null) {
            studentRepositoryrepository.delete(student);
            return true;
        }
        return false;
    }

    public StudentDto getStudent(Long id) {
        Student student = studentRepositoryrepository.findById(id).orElse(null);
        if (student != null) {
            return mapToDto(student);
        }
        return null;
    }

    public Boolean upDate(Long id, StudentDto dto) {
        Student student = studentRepositoryrepository.findById(id).orElse(null);
        if (student != null) {
            studentRepositoryrepository.delete(student);
            Student student1 = mapToEntity(dto);
            studentRepositoryrepository.delete(student1);
            return true;
        }
        return false;
    }

    private Student mapToEntity(StudentDto dto){
            Teacher teacher = teacherRepositoryrepository.findById(dto.getTeacherId()).orElse(null);
            Gruh gruh = gruhRepository.findById(dto.getGroupId()).orElse(null);
            Student student = Student.builder()
                    .id(dto.getId())
                    .firstName(dto.getFirstName())
                    .lastName(dto.getLastName())
                    .teacher(teacher)
                    .gruh(gruh)
                    .build();
            teacher.getStudents().add(student);
            gruh.getStudents().add(student);

            return student;
        }
        private StudentDto mapToDto(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .teacherId(student.getTeacher().getId())
                .groupId(student.getGruh().getId())
                .build();
    }




}
