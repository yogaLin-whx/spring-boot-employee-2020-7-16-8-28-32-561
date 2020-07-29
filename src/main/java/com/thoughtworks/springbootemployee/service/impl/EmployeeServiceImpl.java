package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        //employeeRepository.addEmployee(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return null;
    }

    public void updateEmployeeById(int id, Employee employee) {
        //employeeRepository.updateEmployeeById(id, employee);
    }

    public void deleteEmployeeById(int id) {
        //employeeRepository.deleteEmployeeById(id);
    }

    public List<Employee> pageQueryEmployees(int page, int pageSize) {
        return null;
    }

    public List<Employee> getEmployeesByGender(String gender) {
        return null;
    }
}
