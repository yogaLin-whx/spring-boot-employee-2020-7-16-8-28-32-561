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

    public List<CompanyResponse> getCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companyResponseBoxed(companies);
    }

    private List<CompanyResponse> companyResponseBoxed(List<Company> companies) {
        if(companies != null){
            return companies.stream().map(company -> {
                CompanyResponse companyResponse = new CompanyResponse();
                BeanUtils.copyProperties(company,companyResponse);
                return companyResponse;
            }).collect(Collectors.toList());
        }
        return null;
    }

    private CompanyResponse companyResponseBoxed(Company company){
        if(company != null){
            CompanyResponse companyResponse = new CompanyResponse();
            BeanUtils.copyProperties(company,companyResponse);
            return  companyResponse;
        }
        return null;
    }


    public List<CompanyResponse> getCompanies(Pageable pageable) {
        List<Company> companies = companyRepository.findAll(pageable).toList();
        return companyResponseBoxed(companies);
    }

    public CompanyResponse getCompanyById(int id) {
        return companyResponseBoxed(companyRepository.findById(id).orElse(null));
    }

    public CompanyResponse getEmployeeOfCompany(int id) {
        CompanyResponse companyResponse = new CompanyResponse();
        List<Employee> employees = companyRepository.findAllById(Collections.singleton(id))
            .stream()
            .map(Company::getEmployees)
            .findFirst().orElse(null);
         companyResponse.setEmployees(employees);
         return companyResponse;
    }

    public CompanyResponse addCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        BeanUtils.copyProperties(companyRequest,company);
        company = companyRepository.save(company);
        return companyResponseBoxed(company);
    }

    public CompanyResponse updateCompany(int id,CompanyRequest companyRequest) {
        Company company  = companyRepository.findById(id).orElse(null);
        CompanyResponse companyResponse = new CompanyResponse();
        if(company != null){
            BeanUtils.copyProperties(companyRequest,company);
            company = companyRepository.save(company);
        }
        return companyResponseBoxed(company);
    }

    public CompanyResponse deleteCompanyById(int id) {
        List<Employee> companies = getEmployeeOfCompany(id).getEmployees()
                .stream()
                .peek(employee -> employee.setCompany(null))
                .collect(Collectors.toList());
        companyRepository.deleteById(id);
        return new CompanyResponse();
    }
}
