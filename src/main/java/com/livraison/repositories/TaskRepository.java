package com.livraison.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraison.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
