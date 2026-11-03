package com.learning.jpaRelationships.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Making unidirectional for easy understanding of ManyToMany relationship
//    @ManyToMany(mappedBy = "courses")
//    private List<Student2> students = new ArrayList<>();
}
