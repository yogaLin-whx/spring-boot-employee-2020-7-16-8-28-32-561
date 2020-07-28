package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepository {
    List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public Employee getEmployeeById(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }

    public void updateEmployeeById(int id, Employee newEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setId(newEmployee.getId());
                employee.setName(newEmployee.getName());
                employee.setAge(newEmployee.getAge());
                employee.setGender(newEmployee.getGender());
                employee.setSalary(newEmployee.getSalary());
            }
        }
    }

    public void deleteEmployeeById(int id) {
        for (int i = employees.size() - 1; i >= 0; i--) {
            Employee result = employees.get(i);
            if (result.getId() == id) {
                employees.remove(result);
            }
        }
    }

    public List<Employee> pageQueryEmployees(int page, int pageSize) {
        List<Employee> pagedEmployees = new ArrayList<>();
        int employeeFirstNumber = pageSize * (page - 1);
        if (employees.size() - employeeFirstNumber <= 0) {
            return null;
        }
        for (int employeeNumber = employeeFirstNumber; employeeNumber - employeeFirstNumber < pageSize; employeeNumber ++) {
            if (employeeNumber >= employees.size()) {
                break;
            }
            pagedEmployees.add(employees.get(employeeNumber));
        }
        return pagedEmployees;
    }
}
