package com.example.springitems.controller;

import com.example.springitems.entity.Company;
import com.example.springitems.repository.CompanyRepository;
import com.example.springitems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/companies")
    public String getAllCompanies(ModelMap map) {
        List<Company> companies = companyRepository.findAll();
        map.addAttribute("companies", companies);
        return "companies";
    }


    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute Company company) {
        companyRepository.save(company);
        return "redirect:/companies";
    }

    //jnje che sik che, era or qce exception Hov jan debug e drac run ynchi kudas xelq chi mnace
    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable int id) {
        employeeRepository.deleteEmployeesByCompany_Id(id);
        companyRepository.deleteById(id);

        return "redirect:/companies";
    }
}
