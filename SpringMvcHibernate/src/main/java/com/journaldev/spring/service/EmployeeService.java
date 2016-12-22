package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Employee;

public interface EmployeeService {

	public void updateEmployee(Employee employee);
	public void addEmployee(Employee employee);
	public List<Employee> listEmployee();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
	
	
}
