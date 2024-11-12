package com.example.EmployeeDataInExcel.repo;

import com.example.EmployeeDataInExcel.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e LEFT JOIN e.manager m WHERE e.empId = :empId OR m.empId = :empId")
    List<Employee> findEmployeeByEmpId(@Param("empId") int empId);
}
