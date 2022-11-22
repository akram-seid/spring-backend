package com.example.springbackend.repositories;

import com.example.springbackend.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e  WHERE e.email=?1")
    Optional<Employee> findEmployeeByEmail(String email);


}
