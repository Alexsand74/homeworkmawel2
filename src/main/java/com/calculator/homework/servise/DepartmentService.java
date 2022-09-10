package com.calculator.homework.servise;

import com.calculator.homework.employee.Employee;
import com.calculator.homework.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/department")

public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee fintEmployeeWithMaxSalaryFromDepartment(int department){
        return  employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee fintEmployeeWithMinSalaryFromDepartment(int department){
        return  employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee fintEmployeesFromDepartment(int department){
        return (Employee) employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>>fintEmployees(){
        return  employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }

}
