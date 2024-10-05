package com.example.emp_service.dao;

import com.example.emp_service.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    List<EmployeeEntity> findByDeptId(long deptId);
}
