package com.learning.hibernateFundamentals.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "student_records")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "student_name",
            nullable = false,
            length = 50
    )
    private String name;

    @Column(
            unique = true,
            nullable = false,
            length = 50
    )
    private String email;

    private int age;

    @ElementCollection
    @CollectionTable(
            name = "student_address",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Address> addresses;

    @ElementCollection
    @CollectionTable(
            name = "student_skills",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<String> skills;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "houseNumber",
//                    column = @Column(name = "current_house_Number")
//            ),
//            @AttributeOverride(
//                    name = "street",
//                    column = @Column(name = "current_street")
//            ),
//            @AttributeOverride(
//                    name = "city",
//                    column = @Column(name = "current_city")
//            ),
//            @AttributeOverride(
//                    name = "state",
//                    column = @Column(name = "current_state")
//            ),
//            @AttributeOverride(
//                    name = "pincode",
//                    column = @Column(name = "current_pincode")
//            )
//    })
//    private Address currentAddress;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name = "houseNumber",
//                    column = @Column(name = "permanent_house_Number")
//            ),
//            @AttributeOverride(
//                    name = "street",
//                    column = @Column(name = "permanent_street")
//            ),
//            @AttributeOverride(
//                    name = "city",
//                    column = @Column(name = "permanent_city")
//            ),
//            @AttributeOverride(
//                    name = "state",
//                    column = @Column(name = "permanent_state")
//            ),
//            @AttributeOverride(
//                    name = "pincode",
//                    column = @Column(name = "permanent_pincode")
//            )
//    })
//    private Address permanentAddress;

    public Student(){}

    public Student(Long id, String name,
                   String email, int age,
                   Set<Address> addresses,
                   Set<String> skills
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.addresses = addresses;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }


//        public Address getCurrentAddress() {
//        return currentAddress;
//    }
//
//    public void setCurrentAddress(Address currentAddress) {
//        this.currentAddress = currentAddress;
//    }
//
//    public Address getPermanentAddress() {
//        return permanentAddress;
//    }
//
//    public void setPermanentAddress(Address permanentAddress) {
//        this.permanentAddress = permanentAddress;
//    }

}


