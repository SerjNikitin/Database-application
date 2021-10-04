package com.example.employee.service.impl;

import com.example.employee.domaine.EmployeeEntity;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteEmployeeById(Long id) {
        Optional<EmployeeEntity> byId = employeeRepository.findById(id);
        byId.ifPresent(employeeRepository::delete);
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void saveEntity(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> getEmployeeByFullName(String firstName, String lastName, String patronymic) {
        return employeeRepository.
                findEmployeeEntitiesByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCaseAndPatronymicContainingIgnoreCase(
                        firstName, lastName, patronymic);
    }
}
