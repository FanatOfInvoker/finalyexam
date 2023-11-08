package com.company.finalyexam.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GruhDto {
    Long id;
    String groupName;
    List<Long> studentId = new ArrayList<>();
    Long teacherId;
}
