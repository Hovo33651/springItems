package com.example.springitems.repository;

import com.example.springitems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findAll();

    @Transactional
    void deleteEmployeesByCompany_Id(int id);

}
