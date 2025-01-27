package com.example.ehire.repository;

import com.example.ehire.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository  extends JpaRepository<Company,Long> {
}
