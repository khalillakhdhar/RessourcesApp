package com.livraison.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraison.entities.Employee;
import com.livraison.entities.Team;
import com.livraison.repositories.EmployeeRepository;
import com.livraison.repositories.TaskRepository;
import com.livraison.repositories.TeamRepository;

@Service
public class TeamService implements TeamInterface {

	@Autowired
	TaskRepository taskRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	TeamRepository teamRepository;
	@Override
	public List<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return teamRepository.findAll();
	}

	@Override
	public Team addOneTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepository.save(team);
	}

	@Override
	public Optional<Team> getOneTeam(long id) {
		// TODO Auto-generated method stub
		if(teamRepository.findById(id).isPresent())
			return teamRepository.findById(id);
		else
		return Optional.empty();
	}

	@Override
	public void deleteOne(long id) {
		// TODO Auto-generated method stub
		if(teamRepository.findById(id).isPresent())
			 teamRepository.deleteById(id);;
	}

	@Override
	public Team setLeader(long idTeam, long idLeader) {
		// TODO Auto-generated method stub
		Employee leader=employeeRepository.findById(idLeader).orElse(null);
		Team t=teamRepository.findById(idTeam).orElse(null);
		t.setChef(leader);
		return teamRepository.save(t);
	}

}
