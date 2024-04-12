package org.ayushsingh.jdbc_jpa_demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Entity class representing a department.
 *
 * @author Ayush Singh
 * @version 1.0
 * @since 2024-04-12
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="hb_demo_Department")
@Entity
public class Department {
    

    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long departmentId;

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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", technology='" + technology + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId);
    }
}
