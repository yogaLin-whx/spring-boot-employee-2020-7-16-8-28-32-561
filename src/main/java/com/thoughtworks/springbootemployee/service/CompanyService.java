package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.CompanyRequest;
import com.thoughtworks.springbootemployee.dto.CompanyResponse;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    CompanyResponse getCompanies(Pageable pageable);

    CompanyResponse getCompanyById(int id);

    List<Employee> getEmployeeOfCompany(int id);

    CompanyResponse addCompany(CompanyRequest companyRequest);

    CompanyResponse updateCompany(int id,CompanyRequest companyRequest);

    void deleteCompanyById(int id);
}
