package com.thoughtworks.springbootemployee.dto;

import com.thoughtworks.springbootemployee.entity.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyResponse {

    private List<Company> companies = new ArrayList<>();

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
