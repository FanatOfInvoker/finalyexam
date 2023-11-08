package com.company.finalyexam.service;

import com.company.finalyexam.dto.GruhDto;
import com.company.finalyexam.entity.Gruh;
import com.company.finalyexam.entity.Student;
import com.company.finalyexam.entity.Teacher;
import com.company.finalyexam.repo.GruhRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GruhService {
    private final GruhRepository repository;


    public GruhDto creatGruh(GruhDto dto){
        return null;
    }

    private Gruh mapToEntity(GruhDto dto){
        return Gruh.builder()
                .groupName(dto.getGroupName())

                .build();
    }


    private final TeacherService teacherService;

    public GruhDto creatGruh1(GruhDto dto){
        Gruh gruh = mapToEntity1(dto);
        if (gruh == null) {
            return null;
        }
        repository.save(gruh);
        dto.setId(gruh.getId());
        return dto;
    }

    public Boolean delete(Long id){
        Gruh gruh = repository.findById(id).orElse(null);
        if (gruh != null) {
            repository.delete(gruh);
            return true;
        }
        return false;
    }

    public GruhDto getGruh(Long id){
        return maptoDto(id);
    }

    public Boolean upDate(Long id, GruhDto dto){
        Gruh gruh = mapToEntity1(dto);
        Gruh forDelete = repository.findById(id).orElse(null);
        if (forDelete != null) {
            repository.delete(forDelete);
            repository.save(gruh);
            return true;
        }
        return false;
    }

    private Gruh mapToEntity1(GruhDto dto){
        Gruh gruh = Gruh.builder()
                .groupName(dto.getGroupName())
                .id(dto.getId())
                .build();
        Teacher teacher = teacherService.findTeacher(dto.getTeacherId());
        if (teacher != null) {
            List<Gruh> gruhs = teacher.getGruhs();
            if (gruhs == null) {
                gruhs = new ArrayList<>();
                gruhs.add(gruh);
            }else {
                gruhs.add(gruh);
            }
            gruh.setTeacher(teacher);
        }
        return gruh;
    }

    private GruhDto maptoDto(Long id){
        Gruh gruh = repository.findById(id).orElse(null);
        if (gruh == null) {
            return null;
        }
        return GruhDto.builder()
                .id(gruh.getId())
                .groupName(gruh.getGroupName())
                .studentId(gruh.getStudents().stream().map(Student::getId).collect(Collectors.toList()))
                .teacherId(gruh.getTeacher().getId())
                .build();
    }


}
