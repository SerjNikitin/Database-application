package com.example.employee.controller;

import com.example.employee.domaine.DepartmentEntity;
import com.example.employee.domaine.EmployeeEntity;
import com.example.employee.domaine.PositionEntity;
import com.example.employee.service.DepartmentService;
import com.example.employee.service.EmployeeService;
import com.example.employee.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.employee.domaine.constant.ConstantName.*;

@Controller
@AllArgsConstructor
@RequestMapping(EMPLOYEE)
public class EmployeeController {

    private final EmployeeService employeeService;
    private final PositionService positionService;
    private final DepartmentService departmentService;

    @GetMapping
    public String getAllEmployee(Model model) {
        List<EmployeeEntity> employeeEntityList = employeeService.getAllEmployee();
        model.addAttribute("employeeEntityList", employeeEntityList);
        return "employee/list";
    }

    @GetMapping(FORM)
    public String formForSaveEntity(@RequestParam(required = false) Long id, Model model) {
        List<PositionEntity> positions = positionService.getAllPositions();
        model.addAttribute("positions", positions);
        List<DepartmentEntity> departments = departmentService.getAllDepartment();
        model.addAttribute("departments", departments);
        if (id != null) {
            EmployeeEntity employeeEntity = employeeService.getEmployeeById(id).get();
            model.addAttribute("employeeEntity", employeeEntity);
        } else {
            model.addAttribute("employeeEntity", new EmployeeEntity());
        }
        return "employee/form";
    }

    @PostMapping(FORM)
    public String saveClient(@ModelAttribute EmployeeEntity employeeEntity) {
        employeeService.saveEntity(employeeEntity);
        return "redirect:/employee";
    }

    @GetMapping(FIND)
    public String getClientById(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName,
                                @RequestParam(required = false) String patronymic, Model model) {
        List<EmployeeEntity> employeeEntityList = employeeService.getEmployeeByFullName(firstName,lastName,patronymic);
        model.addAttribute("employeeEntityList", employeeEntityList);
        return "employee/list";
    }

    @GetMapping(DELETE)
    public String delete(@RequestParam Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    @GetMapping(INFO)
    public String getPositionByEmployee(@RequestParam(required = false) Long id, Model model) {
        Optional<EmployeeEntity> departmentById = employeeService.getEmployeeById(id);
        PositionEntity positionEntityList = departmentById.get().getPosition();
        model.addAttribute("positionEntityList", positionEntityList);
        return "position/list";
    }

    @GetMapping(INFO + "/dep")
    public String getDepartmentByEmployee(@RequestParam(required = false) Long id, Model model) {
        Optional<EmployeeEntity> departmentById = employeeService.getEmployeeById(id);
        DepartmentEntity departmentEntity = departmentById.get().getDepartment();
        model.addAttribute("departmentEntityList", departmentEntity);
        return "department/list";
    }

}
