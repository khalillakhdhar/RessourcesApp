package com.livraison.services;

import java.util.List;
import java.util.Optional;

import com.livraison.entities.Team;
import com.livraison.entities.Training;

public interface TrainingInterface {
	public List<Training> getAllTrainings();
	public Team addOneTraining(Training training);
	public Optional<Team> getOneTraining(long id);
	public void deleteOne(long id);
}
