package com.example.emp_service.service;

import com.example.emp_service.dao.EmployeeRepository;
import com.example.emp_service.entity.EmployeeEntity;
import com.example.emp_service.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimp implements EmployeeService {
    EmployeeRepository empRepo;

    @Autowired
    public EmployeeServiceimp(EmployeeRepository empRepo){
        this.empRepo=empRepo;

    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> allEmpEntity= empRepo.findAll();
        List<Employee> allEmp= new ArrayList<>();
        allEmpEntity.stream().forEach((eachEmpEntity)-> {
            Employee emp = new Employee();
            BeanUtils.copyProperties(eachEmpEntity, emp);
            allEmp.add(emp);
        });
        return allEmp;
    }

    @Override
    public Employee getEmployee(long empId) {
        Optional<EmployeeEntity> fetchedEmpEntity =empRepo.findById(empId);
        Employee emp=null;
        if(fetchedEmpEntity.isPresent()){
            emp=new Employee();
            BeanUtils.copyProperties(fetchedEmpEntity.get(),emp);

        }
        return emp;
    }

    @Override
    public Employee addEmployee(Employee newEmployee) {
        EmployeeEntity empEntity = new EmployeeEntity();
        BeanUtils.copyProperties(newEmployee,empEntity);
        empRepo.saveAndFlush(empEntity);
        return newEmployee;
    }

    @Override
    public Employee updateEmployee(Employee editEmployee) {
        EmployeeEntity empEntity= new EmployeeEntity();
        BeanUtils.copyProperties(editEmployee,empEntity);
        empRepo.saveAndFlush(empEntity);
        return editEmployee;
    }

    @Override
    public void deleteEmployee(long empId) {
        empRepo.deleteById(empId);
    }


    @Override
    public List<EmployeeEntity> getAllEmployeesByDepartment(long did){
        return empRepo.findByDeptId(did);
    }




}
