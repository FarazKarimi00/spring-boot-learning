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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "dept_id"
    )
    private Department department;

//    private void addDepartment(Department department) {
//        this.department = department;
//        this.department.getStudents().add(this);
//    }
//    public void removeDepartment(Department department) {
//        this.department = null;
//        this.department.getStudents().remove(this);
//    }
}
