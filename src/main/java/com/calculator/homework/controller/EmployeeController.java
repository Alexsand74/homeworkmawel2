package com.calculator.homework.controller;

import com.calculator.homework.employee.Employee;
import com.calculator.homework.servise.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee (@RequestParam ("firstName") String firstName,
                                   @RequestParam ("lastName") String lastName,
                                    @RequestParam ("departmentId") int department,
                                      @RequestParam ("salary") double salary
    ){
        return employeeService.addEmployee(firstName,lastName,department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee (@RequestParam ("firstName") String firstName,
                                  @RequestParam ("lastName") String lastName,
                                  @RequestParam ("departmentId") int department,
                                  @RequestParam ("salary") double salary
    ){
        return employeeService.findEmployee(firstName,lastName,department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee
            (@RequestParam ("firstName") String firstName,
             @RequestParam ("lastName") String lastName,
             @RequestParam ("departmentId") int department,
             @RequestParam ("salary") double salary
    ){
        return employeeService.removeEmployee(firstName,lastName,department, salary);
    }
    @GetMapping("/all")
    public List<Employee> getAll (){
         return  employeeService.getPrintAll();

    }



}
