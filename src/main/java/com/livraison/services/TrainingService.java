package com.livraison.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraison.entities.Employee;
import com.livraison.entities.Task;
import com.livraison.entities.Team;
import com.livraison.entities.Training;
import com.livraison.repositories.EmployeeRepository;
import com.livraison.repositories.TaskRepository;
import com.livraison.repositories.TrainingRepository;
@Service
public class TrainingService implements TrainingInterface {

	@Autowired
	TrainingRepository trainingRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	TaskRepository taskRepository;
	
	
	@Override
	public List<Training> getAllTrainings() {
		// TODO Auto-generated method stub
		return trainingRepository.findAll();
	}

	@Override
	public Training addOneTraining(Training training) {
		// TODO Auto-generated method stub
		return trainingRepository.save(training);
	}

	@Override
	public Optional<Training> getOneTraining(long id) {
		// TODO Auto-generated method stub
		return trainingRepository.findById(id);
	}

	@Override
	public void deleteOne(long id) {
		// TODO Auto-generated method stub
		if(trainingRepository.findById(id).isPresent())
			trainingRepository.deleteById(id);

	}

	@Override
	public Training addEmployeeToTraining(long idTraining, long idEmployee) {
		// TODO Auto-generated method stub
		Training t1= trainingRepository.findById(idTraining).orElse(null);
		Employee emp1=employeeRepository.findById(idEmployee).orElse(null);
		List<Employee> emps=new ArrayList<Employee>();
		emps=t1.getEmployees();
		emps.add(emp1);
		t1.setEmployees(emps);
		return trainingRepository.save(t1);
		
	}

	@Override
	public Training addTaskToTraining(long idTraining, long idTask) {
		// TODO Auto-generated method stub
		Training t1= trainingRepository.findById(idTraining).orElse(null);
		Task ts1=taskRepository.findById(idTask).orElse(null);
		List<Task> tasks=new ArrayList<Task>();
		tasks=t1.getTasks();
		tasks.add(ts1);
		t1.setTasks(tasks);
		return trainingRepository.save(t1);
	}

}
