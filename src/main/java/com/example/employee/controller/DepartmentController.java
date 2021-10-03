package com.example.employee.controller;

import com.example.employee.domaine.DepartmentEntity;
import com.example.employee.domaine.EmployeeEntity;
import com.example.employee.service.DepartmentService;
import com.example.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.example.employee.domaine.constant.ConstantName.*;

@Controller
@AllArgsConstructor
@RequestMapping(DEPARTMENT)
public class DepartmentController {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @GetMapping
    public String getAllDepartment(Model model, @ModelAttribute("error") String error) {
        model.addAttribute("error", error);
        List<DepartmentEntity> departmentEntityList = departmentService.getAllDepartment();
        model.addAttribute("departmentEntityList", departmentEntityList);
        return "department/list";
    }

    @GetMapping(FORM)
    public String formForSaveEntity(@RequestParam(required = false) Long id, Model model) {
        List<EmployeeEntity> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        if (id != null) {
            DepartmentEntity departmentEntity = departmentService.getDepartmentById(id).get();
            model.addAttribute("departmentEntity", departmentEntity);
        } else {
            model.addAttribute("departmentEntity", new DepartmentEntity());
        }
        return "department/form";
    }

    @PostMapping(FORM)
    public String saveClient(@ModelAttribute DepartmentEntity departmentEntity) {
        departmentService.saveDepartment(departmentEntity);
        return "redirect:/department";
    }

    @GetMapping(INFO)
    public String getAllInfo(@RequestParam(required = false) Long id, Model model) {
        EmployeeEntity employee = departmentService.getManagerByDepartmentId(id);
        model.addAttribute("employeeEntityList", employee);
        return "employee/list";
    }

    @GetMapping(EMPLOYEE)
    public String getAllEmployees(@RequestParam(required = false) Long id, Model model) {
        List<EmployeeEntity> employeeList = departmentService.getEmployeesByDepartmentId(id);
        model.addAttribute("employeeEntityList", employeeList);
        return "employee/list";
    }

    @GetMapping(DELETE)
    public RedirectView delete(@RequestParam Long id, RedirectAttributes attributes) {
        attributes.addFlashAttribute("error", departmentService.deleteDepartmentById(id));
        return new RedirectView("/department");
    }

    @ExceptionHandler(Exception.class)
    public String handleError(HttpServletRequest req, Exception ex) {
        System.err.println("Request: " + req.getRequestURL() + " raised " + ex);
        return "error";
    }

}
