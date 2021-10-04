package com.example.employee.service.impl;

import com.example.employee.domaine.EmployeeEntity;
import com.example.employee.domaine.PositionEntity;
import com.example.employee.repository.PositionRepository;
import com.example.employee.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public List<PositionEntity> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    @Transactional
    public String deletePosition(Long id) {
        PositionEntity byId = positionRepository.findById(id).get();
        if (byId.getEmployees().size() >= 1) {
            return "People work in this position";
        } else {
            positionRepository.deleteById(id);
            return " ";
        }
    }

    @Override
    public Optional<PositionEntity> getPositionById(Long id) {
        return positionRepository.findById(id);
    }

    @Override
    public void savePosition(PositionEntity positionEntity) {
        positionRepository.save(positionEntity);
    }

    @Override
    @Transactional
    public List<EmployeeEntity> getEmployeesByPositionId(Long id) {
        Optional<PositionEntity> byId = positionRepository.findById(id);
        return byId.get().getEmployees();
    }
}
