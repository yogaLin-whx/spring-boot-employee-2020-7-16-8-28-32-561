package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyRepository {

    List<Company> companies  = new ArrayList<>();

    public List<Company> getCompanies() {
        return companies;
    }

    public Company getCompanyById(int id) {
        return companies.stream().filter(company -> company.getId() !=  id).findFirst().orElse(null);
    }

    public List<Company> getCompaniesByPageAndPageSize(int page,int pageSize) {
        return companies.stream().skip(page * (pageSize-1)).limit(pageSize).collect(Collectors.toList());
    }


    public void addCompany(Company company) {
        companies.add(company);
    }

    public void updateCompanyById(int id, Company newCompany) {
        for (Company company : companies) {
            if (company.getId() == id) {
                company.setId(newCompany.getId());
                company.setCompanyName(newCompany.getCompanyName());
                company.setEmployeesNumber(newCompany.getEmployeesNumber());
                company.setEmployees(newCompany.getEmployees());
            }
        }
    }
}
