package com.company.finalyexam.service;

import com.company.finalyexam.dto.GruhDto;
import com.company.finalyexam.entity.Gruh;
import com.company.finalyexam.repo.GruhRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
