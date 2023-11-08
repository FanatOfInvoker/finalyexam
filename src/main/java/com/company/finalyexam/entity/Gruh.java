package com.company.finalyexam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Gruh {
    @Id
    Long id;
    String groupName;
    @OneToMany(mappedBy = "gruh")
    List<Student> students;
    @ManyToOne
    Teacher teacher;

}
