package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

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
