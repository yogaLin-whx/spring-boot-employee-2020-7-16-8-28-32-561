package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public List<EmployeeResponse> getEmployees(Pageable pageable) {
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        employeeRepository.findAll(pageable).toList().forEach(e -> {
            employeeResponseList.add(new EmployeeResponse(e.getName(), e.getAge(), e.getGender(), e.getCompany().getName()));
        });
        return employeeResponseList;
    }

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return new EmployeeResponse(employee.getName(), employee.getAge(), employee.getGender(), employee.getCompany().getName());
    }

    public void updateEmployee(int id, EmployeeRequest employeeRequest) {
        Company company = companyRepository.findById(employeeRequest.getCompanyId()).orElse(null);
        Employee employee = new Employee(id, employeeRequest.getName(), employeeRequest.getAge(), employeeRequest.getGender(), company);
        employeeRepository.save(employee);
    }

    public Boolean deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        return true;
    }

    public List<EmployeeResponse> getEmployeesByGender(String gender) {
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        employeeRepository.findByGender(gender).forEach(e -> {
            employeeResponseList.add(new EmployeeResponse(e.getName(), e.getAge(), e.getGender(), e.getCompany().getName()));
        });
        return employeeResponseList;
    }
}
