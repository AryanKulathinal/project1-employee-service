package com.example.emp_service.service;

import com.example.emp_service.entity.EmployeeEntity;
import com.example.emp_service.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployee(long empId);
    Employee addEmployee(Employee newEmployee);
    Employee updateEmployee(Employee editEmployee);
    void deleteEmployee(long empId);
    List<EmployeeEntity> getAllEmployeesByDepartment(long did);

}
