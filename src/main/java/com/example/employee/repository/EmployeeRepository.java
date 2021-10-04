package com.example.employee.repository;

import com.example.employee.domaine.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

//    Page<EmployeeEntity> findAll(Pageable pageable);


    List<EmployeeEntity>
    findEmployeeEntitiesByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCaseAndPatronymicContainingIgnoreCase(
            String firstName, String lastName, String patronymic);

}
