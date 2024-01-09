package spring_mvc_pesm8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_mvc_pesm8.dao.EmployeeDao;
import spring_mvc_pesm8.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	public Employee saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}

	public Employee loginEmployee(Employee employee) {
		return dao.loginEmployee(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return dao.getAllEmployees();
	}
	
	public Employee deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}
	
	public Employee findEmployee(int id) {
		return dao.findEmployee(id);		
	}
	
	public Employee updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}
}
