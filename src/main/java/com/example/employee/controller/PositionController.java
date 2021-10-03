package com.example.employee.controller;


import com.example.employee.domaine.EmployeeEntity;
import com.example.employee.domaine.PositionEntity;
import com.example.employee.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

import static com.example.employee.domaine.constant.ConstantName.*;

@Controller
@AllArgsConstructor
@RequestMapping(POSITION)
public class PositionController {

    private final PositionService positionService;

    @GetMapping
    public String getAllPosition(Model model, @ModelAttribute("error") String error) {
        model.addAttribute("error", error);
        List<PositionEntity> positionEntityList = positionService.getAllPositions();
        model.addAttribute("positionEntityList", positionEntityList);
        return "position/list";
    }

    @GetMapping(FORM)
    public String formForSavePosition(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            PositionEntity positionEntity = positionService.getPositionById(id).get();
            model.addAttribute("positionEntity", positionEntity);
        } else {
            model.addAttribute("positionEntity", new PositionEntity());
        }
        return "position/form";
    }

    @PostMapping(FORM)
    public String savePosition(@ModelAttribute PositionEntity positionEntity) {
        positionService.savePosition(positionEntity);
        return "redirect:/position";
    }

    @GetMapping(DELETE)
    public RedirectView delete(@RequestParam Long id, RedirectAttributes attributes) {
        attributes.addFlashAttribute("error", positionService.deletePosition(id));
        return new RedirectView("/position");
    }

    @GetMapping(INFO)
    public String getEmployeesByPosition(@RequestParam Long id, Model model) {
        List<EmployeeEntity> employees = positionService.getEmployeesByPositionId(id);
        model.addAttribute("employeeEntityList", employees);
        return "employee/list";
    }
}
