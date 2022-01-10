package org.generation.italy.controller;

//import org.generation.italy.model.Degrees;
import org.generation.italy.model.Department;
import org.generation.italy.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DepartmentController {

	@Autowired
	private DepartmentRepository repository;
	
	@GetMapping
	public String departments(Model model) {
		
		model.addAttribute("departments", repository.findAll(Sort.by("name")));
		return "departments";
	}
	
	@GetMapping("/department/{department_id}")
	public String departmentDegrees (Model model, @PathVariable Integer department_id) {
		
		Department d = repository.getById(department_id);
		model.addAttribute("department", d);
		model.addAttribute("degrees", d.getDegrees());
		return "degrees";
	}
	
}
