package com.company.finalyexam.controller;

import com.company.finalyexam.dto.StudentDto;
import com.company.finalyexam.repo.StudentRepository;
import com.company.finalyexam.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;
    @PostMapping("/add")
    public StudentDto add(@RequestBody StudentDto dto){
        return service.creatStudent(dto);
    }

    @PostMapping("/update/{id}")
    public Boolean add(@PathVariable Long id, @RequestBody StudentDto dto){
        return service.upDate(id,dto);
    }

    @GetMapping("/get/{id}")
    public StudentDto get(@PathVariable Long id){
        return service.getStudent(id);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean add(@PathVariable Long id){
        return service.delete(id);
    }

}
