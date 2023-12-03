package com.livraison.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraison.entities.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

}
