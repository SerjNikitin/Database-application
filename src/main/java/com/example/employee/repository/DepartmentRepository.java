package com.example.employee.repository;

import com.example.employee.domaine.DepartmentEntity;
import com.example.employee.domaine.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
