package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<Employee> getEmployees();

    List<Employee> getEmployeeById(int id);

    void updateEmployeeById(int id, Employee employee);

    void deleteEmployeeById(int id);

    List<Employee> pageQueryEmployees(int page, int pageSize);

    List<Employee> getEmployeesByGender(String gender);
}
