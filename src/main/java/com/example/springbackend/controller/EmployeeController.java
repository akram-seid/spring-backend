package com.example.springbackend.controller;


import com.example.springbackend.Model.Employee;
import com.example.springbackend.service.EmployeeService;
import com.example.springbackend.service.impl.EmployeeServiceImpl;
import com.sun.net.httpserver.Headers;
import io.swagger.v3.oas.models.headers.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
        if(employeeService.saveEmployee(employee)!=null){

            return ResponseEntity.ok(employeeService.saveEmployee(employee));
            // return new  ResponseEntity<>("saved Successfully",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Not created!",HttpStatus.CONFLICT);
    }

    @GetMapping("listall")
    public ResponseEntity<?> findAllEmployees(){
        return new ResponseEntity<> (employeeService.findall(),HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") Long employeeId){

        return new ResponseEntity<>(employeeService.findEmployee(employeeId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee,id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Data Deleted Successfully",HttpStatus.OK);
    }
    @PostMapping("hello")
    public ResponseEntity<Employee> findEmployeeByEmail(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.findByEmail(employee.getEmail()),HttpStatus.OK);
    }
}
