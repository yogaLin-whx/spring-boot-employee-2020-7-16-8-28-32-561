package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import com.thoughtworks.springbootemployee.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

//    @GetMapping("/{id}")
//    public Company getCompanyById(@PathVariable int id){
//        return  companyService.getCompanyById(id);
//    }
//
//    @GetMapping("/{id}/employees")
//    public List<Employee>  getEmployeesOfCompany(@PathVariable int id){
//        return  companyService.getEmployeeOfCompany(id);
//    }
//
    @GetMapping()
    public List<Company> getCompaniesByPageAndPageSize(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
//        if(page != null && pageSize != null){
//            return  companyService.getCompaniesByPageAndPageSize(page,pageSize);
//        }
        return  companyService.getCompanies();
    }
//
//    @PostMapping()
//    public  void  addCompany(@RequestBody Company company){
//        companyService.addCompany(company);
//    }
//
//    @PutMapping("/{id}")
//    public void updateCompanyById(@PathVariable int id, @RequestBody Company company) {
//        companyService.updateCompanyById(id, company);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCompanyById(@PathVariable int id) {
//        companyService.deleteCompanyById(id);
//    }
}
