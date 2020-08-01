package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.dto.CompanyRequest;
import com.thoughtworks.springbootemployee.dto.CompanyResponse;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @GetMapping("/{id}")
    public CompanyResponse getCompanyById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("/{id}/employees")
    public CompanyResponse getEmployeesOfCompany(@PathVariable int id) {
        return companyService.getEmployeeOfCompany(id);
    }

    @GetMapping()
    public List<CompanyResponse> getCompanies(@PageableDefault Pageable pageable,
                                              @RequestParam(required = false, defaultValue = "false") boolean unpaged) {
        if (unpaged) {
            return companyService.getCompanies();
        }
        return companyService.getCompanies(pageable);
    }

    @PostMapping()
    public CompanyResponse addCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.addCompany(companyRequest);
    }

    @PutMapping("/{id}")
    public CompanyResponse updateCompanyById(@PathVariable int id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }

    @DeleteMapping("/{id}")
    public CompanyResponse deleteCompanyById(@PathVariable int id) {
        return companyService.deleteCompanyById(id);
    }
}
