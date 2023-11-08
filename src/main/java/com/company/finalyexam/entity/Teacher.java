package com.company.finalyexam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher {
    @Id
    Long id;
    String firstName;
    String lastName;
    @OneToMany(mappedBy = "teacher")
    List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "teacher")
    List<Gruh> gruhs = new ArrayList<>();

}
