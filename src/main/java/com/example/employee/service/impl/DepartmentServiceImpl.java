package com.example.employee.service.impl;

import com.example.employee.domaine.DepartmentEntity;
import com.example.employee.domaine.EmployeeEntity;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentEntity> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<DepartmentEntity> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void saveDepartment(DepartmentEntity departmentEntity) {
        departmentRepository.save(departmentEntity);
    }

    @Override
    @Transactional
    public String deleteDepartmentById(Long id) {
        DepartmentEntity byId = departmentRepository.findById(id).get();
        if (byId.getEmployeeList().size() >= 1) {
            return "People work in this department";
        }
        if (byId.getEmployee() != null) {
            return "Manager work in this department";
        } else {
            departmentRepository.deleteById(id);
            return " ";
        }
    }

    @Override
    @Transactional
    public EmployeeEntity getManagerByDepartmentId(Long id) {
        Optional<DepartmentEntity> byId = departmentRepository.findById(id);
        return byId.get().getEmployee();
    }

    @Override
    @Transactional
    public List<EmployeeEntity> getEmployeesByDepartmentId(Long id) {
        Optional<DepartmentEntity> byId = departmentRepository.findById(id);
        return byId.get().getEmployeeList();
    }
}
