package com.thoughtworks.springbootemployee.dto;

public class EmployeeRequest {


    private String name;
    private int age;
    private String gender;
    private int companyId;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, int age, String gender, int companyId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.companyId = companyId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
