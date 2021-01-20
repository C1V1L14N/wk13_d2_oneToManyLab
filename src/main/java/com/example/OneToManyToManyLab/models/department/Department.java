package com.example.OneToManyToManyLab.models.department;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.OneToManyToManyLab.models.employee.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"departments"})
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employees;

    public Department(){

    }

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<Employee>();
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee1) {
        this.employees.add(employee1);
    }
}
