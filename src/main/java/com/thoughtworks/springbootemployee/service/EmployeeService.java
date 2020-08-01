package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(EmployeeRequest employeeRequest);
//    Employee addEmployee(Employee employee);

    List<EmployeeResponse> getEmployees(Pageable pageable);

    EmployeeResponse getEmployeeById(int id);

    void updateEmployee(int id,EmployeeRequest employeeRequest);

    Boolean deleteEmployeeById(int id);

    List<EmployeeResponse> getEmployeesByGender(String gender);
}
