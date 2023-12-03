package com.livraison.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraison.entities.Task;
import com.livraison.repositories.EmployeeRepository;
import com.livraison.repositories.TaskRepository;
import com.livraison.repositories.TeamRepository;

@Service
public class TaskService implements TaskInterface {

	@Autowired
	TaskRepository taskRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public Task addOneTask(Task task, long employeeId, long teamId) {
		// TODO Auto-generated method stub
		if(employeeRepository.findById(employeeId).isPresent())
		{
			task.setEmployee(employeeRepository.findById(employeeId).orElse(null));
			
		}
		if(teamRepository.findById(teamId).isPresent())
		{
			task.setTeam(teamRepository.findById(teamId).orElse(null));
			
		}
		return taskRepository.save(task);
	}

	@Override
	public void deleteOneTask(long id) {
		// TODO Auto-generated method stub
		if(taskRepository.findById(id).isPresent())
		taskRepository.deleteById(id);

	}

	@Override
	public Optional<Task> findOneTask(long id) {
		// TODO Auto-generated method stub
		if(taskRepository.findById(id).isPresent())
return 		taskRepository.findById(id);
		else

		return Optional.empty();
	}

}
