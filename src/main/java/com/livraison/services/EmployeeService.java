package com.livraison.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraison.entities.Employee;
import com.livraison.entities.Team;
import com.livraison.repositories.EmployeeRepository;
import com.livraison.repositories.TeamRepository;
@Service
public class EmployeeService implements EmployeeInterface {
@Autowired
	private EmployeeRepository employeeRepository;
@Autowired
	private TeamRepository teamRepository;
	@Override
	public List<Employee> getAllimEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee addOneEmployee(Employee employee, long teamid) {
		// TODO Auto-generated method stub
		if(teamRepository.findById(teamid).isPresent())
		{
			Team team=teamRepository.findById(teamid).orElse(null);
			employee.setTeam(team);
			return employeeRepository.save(employee);
		}
		else
		return null;
	}

	@Override
	public void deleteOne(long id) {
		// TODO Auto-generated method stub
		if(employeeRepository.findById(id).isPresent())
			employeeRepository.deleteById(id);
		

	}

	@Override
	public Optional<Employee> getOne(long id) {
		// TODO Auto-generated method stub
		if(employeeRepository.findById(id).isPresent())

		return employeeRepository.findById(id);
		else
			return null;
	}

	@Override
	public Employee updateOne(long id, Employee employee) {
		// TODO Auto-generated method stub
		if(employeeRepository.findById(id).isPresent())
			return employeeRepository.save(employee);
		else
		return null;
	}

}
