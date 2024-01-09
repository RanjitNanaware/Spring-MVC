package spring_mvc_pesm8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc_pesm8.EmployeeService;
import spring_mvc_pesm8.dto.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	ModelAndView modelAndView = new ModelAndView();

	@RequestMapping("signUp")
	public ModelAndView signUpEmployee() {
		modelAndView.addObject("employee", new Employee());
		modelAndView.setViewName("signUp.jsp");
		return modelAndView;
	}

	@RequestMapping("save")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		service.saveEmployee(employee);
		modelAndView.setViewName("home.jsp");
		return modelAndView;
	}

	@RequestMapping("loginpage")
	public ModelAndView login() {
		modelAndView.addObject("employee", new Employee());
		modelAndView.setViewName("login.jsp");
		return modelAndView;
	}

	@RequestMapping("login")
	public ModelAndView loginEmployee(@ModelAttribute Employee employee) {
		Employee dbemployee = service.loginEmployee(employee);
		if (dbemployee != null) {
			List<Employee> employees = service.getAllEmployees();
			modelAndView.addObject("list", employees);
			modelAndView.setViewName("success.jsp");
			return modelAndView;
		} else {
			modelAndView.setViewName("home.jsp");
			return modelAndView;
		}

	}

	@RequestMapping("delete")
	public ModelAndView deleteEmployee(@RequestParam int id) {
		Employee dbemployee = service.deleteEmployee(id);
		if (dbemployee != null) {
			List<Employee> employees = service.getAllEmployees();
			modelAndView.addObject("list", employees);
			modelAndView.setViewName("success.jsp");
			return modelAndView;
		} else {
			modelAndView.setViewName("home.jsp");
			return modelAndView;
		}

	}

	@RequestMapping("update")
	public ModelAndView update(@RequestParam int id) {
		Employee employee = service.findEmployee(id);
		modelAndView.addObject(employee);
		modelAndView.setViewName("edit.jsp");
		return modelAndView;
	}

	@RequestMapping("edit")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		Employee employee2 = service.updateEmployee(employee);
		if (employee2 != null) {
			List<Employee> employees = service.getAllEmployees();
			modelAndView.addObject("list", employees);
			modelAndView.setViewName("success.jsp");
			return modelAndView;
		} else {
			modelAndView.setViewName("home.jsp");
			return modelAndView;
		}

	}

}
