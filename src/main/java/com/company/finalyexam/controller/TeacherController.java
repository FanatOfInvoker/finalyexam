package com.company.finalyexam.controller;

import com.company.finalyexam.dto.GruhDto;
import com.company.finalyexam.dto.TeacherDto;
import com.company.finalyexam.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService service;
    @PostMapping("/add")
    public TeacherDto add(@RequestBody TeacherDto dto){
        return service.creatTeacher(dto);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return service.delete(id);
    }

    @GetMapping("/get/{id}")
    public TeacherDto get(@PathVariable Long id){
        return service.getTeacher(id);
    }
    @PostMapping("/update/{id}")
    public Boolean upDate(@PathVariable Long id, @RequestBody TeacherDto dto){
        return service.upDate(id,dto);
    }
}
