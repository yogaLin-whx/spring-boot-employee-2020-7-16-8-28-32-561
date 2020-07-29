package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getCompanies() {
        return  companyRepository.getCompanies();
    }

    public Company getCompanyById(int id) {
        return  companyRepository.getCompanyById(id);
    }

    public List<Company> getCompaniesByPageAndPageSize(int page,int pageSize){
        return  companyRepository.getCompaniesByPageAndPageSize(page,pageSize);
    }

    public List<Employee> getEmployeeOfCompany(int id) {
        return companyRepository.getCompanyById(id).getEmployees();
    }

    public void addCompany(Company company) {
        companyRepository.addCompany(company);
    }

    public void updateCompanyById(int id, Company company) {
        companyRepository.updateCompanyById(id, company);
    }

    public void deleteCompanyById(int id) {
        companyRepository.deleteCompanyById(id);
    }
}
