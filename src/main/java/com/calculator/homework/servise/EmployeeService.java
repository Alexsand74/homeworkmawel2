package com.calculator.homework.servise;

import com.calculator.homework.employee.Employee;
import com.calculator.homework.exception.EmployeeAlreadyAddedException;
import com.calculator.homework.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private static final int MAX = 10;
//    private List<Employee>  employees = new ArrayList<>();
//*********** Переделка List на Map для домашнего задания Коллекция и многообразие ***********
    private Map<String, Employee> employees;
    public EmployeeService(){ this.employees = new HashMap<>();
    }

//    public Employee addEmployee (String firstName, String lastName){
//        Employee employee = new Employee(firstName,lastName);
//          if ( employees.contains(employee)){
//            throw  new EmployeeAlreadyAddedException();
//              }
//          if ( employees.size() < MAX) {
//              employees.add(employee);
//              return employee;
//          }
//          throw new EmployeeStorageIsFullException();
//    }
    public Employee addEmployee (String firstName, String lastName){
        Employee employee = new Employee(firstName,lastName);
          if ( employees.containsKey(employee.getFullName())){
            throw  new EmployeeAlreadyAddedException(); }
                       employees.put(employee.getFullName(), employee);
              return employee;
             }

//    public Employee findEmployee (String firstName, String lastName) {
//        Employee employee = new Employee(firstName, lastName);
//        if (employees.contains(employee)) {
//            return employee;
//        } else {
//            throw new EmployeeNotFoundException();
//        }
//    }
    public Employee findEmployee (String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get (employee.getFullName());
        } else {
            throw new EmployeeNotFoundException();
        }
    }

//    public Employee removeEmployee (String firstName, String lastName){
//        Employee employee = new Employee(firstName, lastName);
//        if (employees.contains(employee)) {
//            employees.remove(employee);
//            return employee;
//        } else {
//            throw new EmployeeNotFoundException();
//        }
//}
public Employee removeEmployee (String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
}
//    public List<Employee> getPrintAll (){
//        return new ArrayList<>(employees);
//    }
    public Collection<Employee> getPrintAll (){
        return Collections.unmodifiableCollection(employees.values());
    }

// *********** методы при работе с массивом объектов **********************************
//
//        public Employee addEmployee (String firstName, String lastName){
//            Employee employee = new Employee(firstName,lastName);
//       int indexArrey = -1;
//       for (int i = 0; i < employees.length; i++){
//           if( Objects.equals(employees[i],employee)){ // проверка на равность безопасна для null
//               throw new EmployeeAlreadyAddedException();
//           }
//           if ( Objects.isNull(employees[i])){ // проверка на null
//               indexArrey = i;
//               break;
//           }
//       }
//       if (indexArrey != -1) {
//           return employees[indexArrey] = employee;
//       }
//       throw new EmployeeStorageIsFullException();
//       }
//
//    public Employee findEmployee (String firstName, String lastName){
//        Employee employee = new Employee(firstName,lastName);
//         for (int i = 0; i < employees.length; i++) {
//             if (Objects.equals(employees[i], employee)) {
//                 return employee;
//             }
//         }
//        throw new EmployeeNotFoundException();
//    }
//
//    public Employee removeEmployee (String firstName, String lastName){
//        Employee employee = new Employee(firstName,lastName);
//        for (int i = 0; i < employees.length; i++) {
//            if (Objects.equals(employees[i], employee)) {
//                 employees[i] = null ;
//                 return employee;
//            }
//        }
//        throw new EmployeeNotFoundException();
//    }
}
