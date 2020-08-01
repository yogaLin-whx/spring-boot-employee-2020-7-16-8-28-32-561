package com.thoughtworks.springbootemployee.integration;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyIntegrationTest {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    MockMvc mockMvc;

    @AfterEach
    public void clear(){
        companyRepository.deleteAll();
    }

    @BeforeEach
    public  void clearBefore(){
        companyRepository.deleteAll();
    }

    @Test
    void should_get_1_company_when_find_all_companies_given_1_company() throws Exception {
        companyRepository.save(new Company("ooocl"));
        mockMvc.perform(get("/companies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("companies[0].name").value("ooocl"));
    }

    @Test
    void should_get_2_company_when_find_all_companies_given_2companies() throws Exception {
        companyRepository.save(new Company("oocl"));
        companyRepository.save(new Company("ooocl"));
        mockMvc.perform(get("/companies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("companies[0].name").value("oocl"))
                .andExpect(jsonPath("companies[1].name").value("ooocl"));
    }

    @Test
    void should_get_1_company_when_add_companies_given_1company() throws Exception {
        String companyJson = "{\n" +
                "    \"name\":\"oodl\" \n" +
                "}";
        mockMvc.perform(post("/companies")
                .contentType(MediaType.APPLICATION_JSON).content(companyJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("companies[0].name").value("oodl"));
    }

    @Test
    void should_get_update_company_response_when_update_company_given_company_request_and_exist_company() throws Exception {
        Company company  = new Company();
        company.setName("oodl");
        company = companyRepository.save(company);
        String companyJson = "{\n" +
                "    \"name\":\"oocl\" \n" +
                "}";
        mockMvc.perform(put("/companies/" + company.getId())
                .contentType(MediaType.APPLICATION_JSON).content(companyJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("companies[0].name").value("oocl"));
    }

    @Test
    void should_return_null_when_delete_company_given_company_id_with_exist_company() throws Exception {
        Company company = new Company();
        company.setName("oodl");
        companyRepository.save(company);

        mockMvc.perform(delete("/companies/" + company.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void should_return_company_with_same_id_when_find_company_by_id_given_company() throws Exception {
        Company  company = new Company();
        company.setName("oodl");
        companyRepository.save(company);

        mockMvc.perform(get("/companies/" + company.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("companies[0].name").value("oodl"));
    }



}
