package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Employee;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired(required = true)
	@Qualifier(value = "employeeService")
	public void setemployeeService(EmployeeService es) {
		this.employeeService = es;
	}

	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String listEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployee", this.employeeService.listEmployee());
		return "employee";
	}
	
	@RequestMapping(value= "/employee/add", method = RequestMethod.POST)
		public String addEmployee(@ModelAttribute("employee") Employee employee){
			
			if(employee.getId() == 0){
				this.employeeService.addEmployee(employee);
			}else{
				this.employeeService.updateEmployee(employee);
			}
			
			return "redirect:/employee";
	}

}
