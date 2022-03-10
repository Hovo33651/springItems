package com.example.springitems.repository;

import com.example.springitems.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    List<Company> findAll();
}
