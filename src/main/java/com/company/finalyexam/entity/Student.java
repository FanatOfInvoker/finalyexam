package com.company.finalyexam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    Long id;
    String firstName;
    String lastName;
    @ManyToOne
    Gruh gruh;
    @ManyToOne
    Teacher teacher;

}
