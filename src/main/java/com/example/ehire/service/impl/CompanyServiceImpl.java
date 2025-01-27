package com.example.ehire.service.impl;

import com.example.ehire.model.Company;

import java.util.List;

public interface CompanyServiceImpl {
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    boolean updateCompany(Long id, Company company);

    void addCompany(Company company);
    boolean removeCompany(Long id);
}
