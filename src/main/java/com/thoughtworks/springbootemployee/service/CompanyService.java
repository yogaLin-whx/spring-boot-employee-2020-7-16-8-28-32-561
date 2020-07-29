package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {

    Page<Company> getCompanies(Pageable pageable);
//
//    Company getCompanyById(int id);
//
//    List<Company> getCompaniesByPageAndPageSize(int page,int pageSize);
//
//    List<Employee> getEmployeeOfCompany(int id);
//
//    void addCompany(Company company);
//
//    void updateCompanyById(int id, Company company);
//
//    void deleteCompanyById(int id);
}
