package guru.springframework.MyFirstProject.controllers;

import guru.springframework.MyFirstProject.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/employees")
    public String getEmployees(Model model){
        model.addAttribute("employees",employeeRepository.findAll());
        return "employees";
    }
}
