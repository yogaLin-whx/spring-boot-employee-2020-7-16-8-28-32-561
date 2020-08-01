package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.CompanyRequest;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    Page<Company> getCompanies(Pageable pageable);

    List<Company> getCompanyById(int id);

    List<Employee> getEmployeeOfCompany(int id);

    Company addCompany(CompanyRequest companyRequest);

    void updateCompany(Company company);

    void deleteCompanyById(int id);
}
