package com.example.springitems.repository;

import com.example.springitems.entity.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company,Integer> {

    List<Company> findAll();
}