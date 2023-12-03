package com.livraison.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraison.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
