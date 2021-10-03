package com.example.employee.service;

import com.example.employee.domaine.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployee();

    void deleteEmployeeById(Long id);

    Optional<EmployeeEntity> getEmployeeById(Long id);

    void saveEntity(EmployeeEntity employeeEntity);

    List<EmployeeEntity> getEmployeeByFullName(String firstName,String lastName, String patronymic);
}
