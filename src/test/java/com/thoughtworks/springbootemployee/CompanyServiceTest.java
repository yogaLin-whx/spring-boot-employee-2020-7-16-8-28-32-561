package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.service.CompanyService;
import com.thoughtworks.springbootemployee.service.impl.CompanyServiceImpl;
import javafx.beans.binding.When;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    @Mock
    CompanyRepository companyRepository;

    @InjectMocks
    CompanyServiceImpl companyService;

    @Test
    void should_return_2companies_when_get_companies_given_2companies(){
        //given
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            companies.add(new Company());
        }
        Mockito.when(companyRepository.getCompanies()).thenReturn(companies);

        //when
        List<Company> companiesResult = companyService.getCompanies();

        //then
        assertEquals(2,companiesResult.size());
    }

    @Test
    void should_return_0companies_when_get_companies_given_0companies() {
        //given
        List<Company> companies = new ArrayList<>();
        Mockito.when(companyRepository.getCompanies()).thenReturn(companies);

        //when
        List<Company> companiesResult = companyService.getCompanies();

        //then
        assertEquals(0, companiesResult.size());
    }
}
