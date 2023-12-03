package com.livraison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.livraison.entities.Employee;
import com.livraison.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("employees")
public class EmployeeController {
@Autowired
EmployeeService employeeService;
@GetMapping
public ResponseEntity<List<Employee>> getEmployees()
{
return 	ResponseEntity.ok(employeeService.getAllimEmployees());
}
@PostMapping("/{teamid}")
@ResponseStatus(HttpStatus.CREATED)
public Employee addEmployee(@RequestBody @Valid Employee employee,@PathVariable long teamId)
{
	return employeeService.addOneEmployee(employee, teamId);
}
@GetMapping("/{id}")
public ResponseEntity<Employee> findEmployee(@PathVariable long Id)
{
if(!employeeService.getOne(Id).isPresent())
	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
else
	return ResponseEntity.ok(employeeService.getOne(Id).get());

}
@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)

public void deleteEmployee(@PathVariable long Id)
{
	employeeService.deleteOne(Id);
	}
}
