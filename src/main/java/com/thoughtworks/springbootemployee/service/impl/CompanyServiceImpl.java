package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.dto.CompanyRequest;
import com.thoughtworks.springbootemployee.dto.CompanyResponse;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Page<Company> getCompanies(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public List<Company> getCompanyById(int id) {
        return  companyRepository.findAllById(Collections.singleton(id));
    }

    public List<Employee> getEmployeeOfCompany(int id) {
        return companyRepository.findAllById(Collections.singleton(id))
                .stream()
                .map(Company::getEmployees)
                .findAny()
                .orElseThrow(CompanyNotFoundException::new);
    }

    public CompanyResponse addCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        BeanUtils.copyProperties(companyRequest,company);
        company = companyRepository.save(company);
        CompanyResponse companyResponse = new CompanyResponse();
        BeanUtils.copyProperties(company,companyResponse);
        return companyResponse;
    }

    public CompanyResponse updateCompany(int id,CompanyRequest companyRequest) {
        Company company  = companyRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(companyRequest,company);
        company = companyRepository.save(company);
        CompanyResponse companyResponse = new CompanyResponse();
        BeanUtils.copyProperties(company,companyResponse);
        return companyResponse;
    }

    public void deleteCompanyById(int id) {
        List<Employee> companies = getEmployeeOfCompany(id)
                .stream()
                .peek(employee -> employee.setCompany(null))
                .collect(Collectors.toList());
        companyRepository.deleteById(id);
    }
}
