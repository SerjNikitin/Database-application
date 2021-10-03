package com.example.employee.service;

import com.example.employee.domaine.EmployeeEntity;
import com.example.employee.domaine.PositionEntity;

import java.util.List;
import java.util.Optional;

public interface PositionService {
    List<PositionEntity>getAllPositions();

    String deletePosition(Long id);

    Optional<PositionEntity> getPositionById(Long id);

    void savePosition(PositionEntity positionEntity);

    List<EmployeeEntity> getEmployeesByPositionId(Long id);
}
