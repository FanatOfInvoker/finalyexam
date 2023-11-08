package com.company.finalyexam.controller;

import com.company.finalyexam.dto.GruhDto;
import com.company.finalyexam.service.GruhService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gruh")
public class GruhController {
    private final GruhService service;

    @PostMapping("/add")
    public GruhDto add(@RequestBody GruhDto dto){
        return service.creatGruh1(dto);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return service.delete(id);
    }

    @GetMapping("/get/{id}")
    public GruhDto get(@PathVariable Long id){
        return service.getGruh(id);
    }
    @PostMapping("/update/{id}")
    public Boolean upDate(@PathVariable Long id, @RequestBody GruhDto dto){
        return service.upDate(id,dto);
    }
}
