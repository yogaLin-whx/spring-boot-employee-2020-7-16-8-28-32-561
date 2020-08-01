package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import com.thoughtworks.springbootemployee.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping()
    public Employee addEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.addEmployee(employeeRequest);
    }
//    @PostMapping()
//    public Employee addEmployee(@RequestBody Employee employee){
//        return employeeService.addEmployee(employee);
//    }

    @GetMapping()
    public List<EmployeeResponse> getEmployees(@PageableDefault Pageable pageable,
                                               @RequestParam(value = "gender", required = false) String gender){
        if (gender != null) {
            return employeeService.getEmployeesByGender(gender);
        }
        return employeeService.getEmployees(pageable);
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployeeById(@PathVariable int id,@RequestBody EmployeeRequest employeeRequest){
        employeeService.updateEmployee(id,employeeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable("id")int id){
        employeeService.deleteEmployeeById(id);
    }
}
