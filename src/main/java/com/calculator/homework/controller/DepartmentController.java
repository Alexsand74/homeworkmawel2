package com.calculator.homework.controller;


import com.calculator.homework.employee.Employee;
import com.calculator.homework.servise.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController ( DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @RequestMapping("/max-salary")
    public Employee fintEmployeeWithMaxSalaryFromDepartment (@RequestParam("departmentId") int department) {
           return  departmentService.fintEmployeeWithMaxSalaryFromDepartment(department); }


    @RequestMapping( "/min-salary")
    public Employee fintEmployeeWithMinSalaryFromDepartment (@RequestParam("departmentId") int department) {
            return  departmentService.fintEmployeeWithMinSalaryFromDepartment(department); }

    @RequestMapping( value = "/all", params = "departmentId")
    public List<Employee> fintEmployeesFromDepartment (@RequestParam("departmentId") int department) {
           return (List<Employee>) departmentService.fintEmployeesFromDepartment(department); }

    @RequestMapping( "/all")
    public Map<Integer, List<Employee>> fintEmployees () {
              return  departmentService.fintEmployees(); }


}
