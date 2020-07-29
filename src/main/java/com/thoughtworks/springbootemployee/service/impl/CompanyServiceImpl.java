package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

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
                .findFirst().get();
    }

    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public void updateCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteCompanyById(int id) {
        companyRepository.deleteById(id);
    }
}
