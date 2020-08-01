package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Employee addEmployee(EmployeeRequest employeeRequest) {

        Company company = companyRepository.findById(employeeRequest.getCompanyId()).orElse(null);
        if (company != null) {
            return employeeRepository.save(new Employee(employeeRequest.getName(), employeeRequest.getAge(), employeeRequest.getGender(), company));
        }
        return null;
    }
//
//    public Employee addEmployee(Employee employee) {
//        return employeeRepository.save(employee);
//    }


    public List<EmployeeResponse> getEmployees(Pageable pageable) {
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        employeeRepository.findAll(pageable).toList().stream().forEach(e -> {
            employeeResponseList.add(new EmployeeResponse(e.getName(), e.getAge(), e.getGender(), e.getCompany().getName()));
        });
        return employeeResponseList;
    }

    public List<Employee> getEmployeeById(int id) {
        return employeeRepository.findAllById(Collections.singleton(id));
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    public List<EmployeeResponse> getEmployeesByGender(String gender) {
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        BeanUtils.copyProperties(employeeRepository.findByGender(gender),employeeResponseList);
        return employeeResponseList;
    }
}
