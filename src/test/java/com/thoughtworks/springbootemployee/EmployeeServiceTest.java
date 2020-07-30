package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import com.thoughtworks.springbootemployee.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    CompanyRepository companyRepository;

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

//    @Test
//    public void should_return_employee_when_add_addEmployee_given_employee_request_and_company_is_exist(){
//        //given
//        EmployeeRequest employeeRequest  = new EmployeeRequest(1,"cc",18,"male",1);
//        Employee employee = new Employee(1,"cc",18,"male");
//        int  companyId = 1;
//        Company company = new Company();
//        company.setId(companyId);
//        Mockito.when(companyRepository.findById(companyId)).thenReturn(Optional.of(company));
//        Mockito.when(employeeRepository.save(any())).thenReturn(employee);
//
//        //when
//        Employee employeeResult = employeeService.addEmployee(employeeRequest);
//
//        //then
//        assertNotNull(employeeResult);
//    }


}
