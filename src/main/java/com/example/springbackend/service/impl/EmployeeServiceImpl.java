package com.example.springbackend.service.impl;

import com.example.springbackend.Model.Employee;
import com.example.springbackend.exception.ResourceNotFoundException;
import com.example.springbackend.repositories.EmployeeRepository;
import com.example.springbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee saveEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    public Employee findEmployee(Long id ) {
        Optional<Employee> employee= employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new ResourceNotFoundException("Employee","Id",id);
        }

         }

    public Employee updateEmployee(Employee employee, Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","ID",id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }

    public Employee findByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Employee","Email",email));

    }


    public List<Employee> findall() {
        return employeeRepository.findAll();
    }
}
