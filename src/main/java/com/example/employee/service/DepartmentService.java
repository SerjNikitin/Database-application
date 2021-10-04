package com.example.employee.service;

import com.example.employee.domaine.DepartmentEntity;
import com.example.employee.domaine.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<DepartmentEntity> getAllDepartment();

    Optional<DepartmentEntity> getDepartmentById(Long id);

    void saveDepartment(DepartmentEntity departmentEntity);

    String deleteDepartmentById(Long id);

    EmployeeEntity getManagerByDepartmentId(Long id);

    List<EmployeeEntity> getEmployeesByDepartmentId(Long id);
}
