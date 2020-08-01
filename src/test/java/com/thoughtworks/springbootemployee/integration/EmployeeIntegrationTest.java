package com.thoughtworks.springbootemployee.integration;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @AfterEach
    public void clear() {
        employeeRepository.deleteAll();
    }


    @BeforeEach
    public void clearBefore() {
        employeeRepository.deleteAll();
    }

    @Test
    public void should_add_employee_when_add_employee_given_1employee_request() throws Exception {
        //given
        Company company = new Company();
        int companyId = 1;
        company.setId(companyId);
        companyRepository.save(company);
        String employeeJson = "{\n" +
                "    \"name\": \"oliver\",\n" +
                "    \"gender\":\"male\",\n" +
                "    \"age\":18,\n" +
                "    \"companyId\":1\n" +
                "}";
        //when

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("oliver"))
                .andExpect(jsonPath("gender").value("male"))
                .andExpect(jsonPath("age").value(18));

    }

    @Test
    void should_get_2_employees_when_select_all_employess_given_2_employees() throws Exception {
        //given
        Company company = new Company("oocl");
        companyRepository.save(company);
        employeeRepository.save(new Employee("oliver", 18, "male", company));
        employeeRepository.save(new Employee("chris", 18, "male", company));

        //when
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].name").value("oliver"))
                .andExpect(jsonPath("[1].name").value("chris"));
    }
}
