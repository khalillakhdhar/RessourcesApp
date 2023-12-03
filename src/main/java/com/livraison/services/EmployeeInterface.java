package com.livraison.services;

import java.util.List;
import java.util.Optional;

import com.livraison.entities.Employee;

public interface EmployeeInterface {
	public List<Employee> getAllimEmployees();
	public Employee addOneEmployee(Employee employee,long teamid);
	public void deleteOne(long id);
	public Optional<Employee> getOne(long id);
	public Employee updateOne(long id,Employee employee);
}
