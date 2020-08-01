package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.CompanyRequest;
import com.thoughtworks.springbootemployee.dto.CompanyResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    List<CompanyResponse> getCompanies(Pageable pageable);

    CompanyResponse getCompanyById(int id);

    CompanyResponse getEmployeeOfCompany(int id);

    CompanyResponse addCompany(CompanyRequest companyRequest);

    CompanyResponse updateCompany(int id, CompanyRequest companyRequest);

    CompanyResponse deleteCompanyById(int id);
}
