package com.example.springitems.controller;

import com.example.springitems.dto.CreateEmployeeRequest;
import com.example.springitems.entity.Employee;
import com.example.springitems.service.CompanyService;
import com.example.springitems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;


    @GetMapping("/employees")
    public String getAllEmployees(ModelMap map){
        List<Employee> employees = employeeService.findAll();
        map.addAttribute("employees",employees);
        map.addAttribute("companies", companyService.findAll());
        return "employees";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute CreateEmployeeRequest employeeRequest,
                              @RequestParam("pictures") MultipartFile[] uploadedFiles) throws IOException {
        employeeService.addEmployeeFromEmployeeRequest(employeeRequest,uploadedFiles);
        return "redirect:/employees";
    }

}

