package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

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
}
