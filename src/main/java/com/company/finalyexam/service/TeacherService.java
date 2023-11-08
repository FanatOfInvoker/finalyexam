package com.company.finalyexam.service;

import com.company.finalyexam.dto.TeacherDto;
import com.company.finalyexam.entity.Gruh;
import com.company.finalyexam.entity.Student;
import com.company.finalyexam.entity.Teacher;
import com.company.finalyexam.repo.GruhRepository;
import com.company.finalyexam.repo.StudentRepository;
import com.company.finalyexam.repo.TeacherRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;
    private final GruhRepository gruhRepository;
    private final StudentRepository studentRepository;

    public Teacher findTeacher(Long id){
        return repository.findById(id).orElse(null);
    }
    public TeacherDto getTeacher(Long id){
        Teacher teacher = findTeacher(id);
        return mapToDto(teacher);
    }
    public TeacherDto creatTeacher(TeacherDto dto){
        Teacher teacher = mapToEntity(dto);
        repository.save(teacher);
        return dto;
    }

    public Boolean upDate(Long id, TeacherDto dto){
        Teacher teacher = findTeacher(id);
        if (teacher != null) {
            repository.delete(teacher);
            repository.save(mapToEntity(dto));
            return true;
        }
        return false;
    }

    public Boolean delete(Long id) {
        Teacher teacher = findTeacher(id);
        if (teacher != null) {
            repository.delete(teacher);
            return true;
        }
        return false;

    }

    private Teacher mapToEntity(TeacherDto dto){
        return Teacher.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .gruhs(dto.getGruhsId().stream()
                        .map(gruhRepository::findById)
                        .map(e->e.orElse(null))
                        .collect(Collectors.toList()))
                .students(dto.getStudentsId().stream()
                        .map(studentRepository::findById)
                        .map(e-> e.orElse(null)).collect(Collectors.toList()))
                .build();
    }

    private TeacherDto mapToDto(Teacher teacher){
        return TeacherDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .gruhsId(teacher.getGruhs().stream()
                        .map(Gruh::getId)
                        .collect(Collectors.toList()))
                .studentsId(teacher.getStudents().stream()
                        .map(Student::getId)
                        .collect(Collectors.toList()))
                .build();
    }


}
