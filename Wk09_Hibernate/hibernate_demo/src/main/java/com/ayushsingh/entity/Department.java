package com.ayushsingh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="hb_demo_Department")
@Entity
public class Department {
    

    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(name="Name", nullable = false,unique = true)
    private String name;

    @Column(name="Technology", nullable = false)
    private String technology;

    @Column(name="Address", nullable = false)
    private String address;

    @Column(name="Contact", nullable = false, unique = true, length = 10)
    private Long contact;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH}, fetch = FetchType.LAZY)
    Set<Employee> employees = new HashSet<>();
}
