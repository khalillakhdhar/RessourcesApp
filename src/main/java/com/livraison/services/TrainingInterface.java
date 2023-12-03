package com.livraison.services;

import java.util.List;
import java.util.Optional;

import com.livraison.entities.Team;
import com.livraison.entities.Training;

public interface TrainingInterface {
	public List<Training> getAllTrainings();
	public Training addOneTraining(Training training);
	public Optional<Training> getOneTraining(long id);
	public void deleteOne(long id);
	public Training addEmployeeToTraining(long idTraining, long idEmployee);
	public Training addTaskToTraining(long idTraining, long idTask);
}
