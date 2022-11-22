package com.example.springbackend.service;

import com.example.springbackend.Model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
     List<Employee> getEmployees();
     Employee findEmployee(Long id);
     Employee updateEmployee(Employee employee, Long id);
     void deleteEmployee(Long id);
     Employee findByEmail(String email);


}
