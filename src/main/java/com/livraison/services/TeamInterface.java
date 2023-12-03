package com.livraison.services;

import java.util.List;
import java.util.Optional;

import com.livraison.entities.Team;

public interface TeamInterface {
public List<Team> getAllTeams();
public Team addOneTeam(Team team);
public Optional<Team> getOneTeam(long id);
public void deleteOne(long id);
public Team setLeader(long idTeam,long idLeader);

}
