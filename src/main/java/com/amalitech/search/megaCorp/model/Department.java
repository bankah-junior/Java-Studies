package com.amalitech.search.megaCorp.model;

import java.util.List;

public class Department {
    String name;
    List<Integer> interns;
    List<Integer> managers;
    List<Department> subDepartments;

    public Department(String name, List<Integer> interns, List<Integer> managers, List<Department> subDepartments) {
        this.name = name;
        this.interns = interns;
        this.managers = managers;
        this.subDepartments = subDepartments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getInterns() {
        return interns;
    }

    public void setInterns(List<Integer> interns) {
        this.interns = interns;
    }

    public List<Integer> getManagers() {
        return managers;
    }

    public void setManagers(List<Integer> managers) {
        this.managers = managers;
    }

    public List<Department> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(List<Department> subDepartments) {
        this.subDepartments = subDepartments;
    }
}

