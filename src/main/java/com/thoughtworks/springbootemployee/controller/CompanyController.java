package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public List<Company> getCompanies(){
        return  companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable int id){
        return  companyService.getCompanyById(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee>  getEmployeesOfCompany(@PathVariable int id){
        return  companyService.getEmployeeOfCompany(id);
    }
}
