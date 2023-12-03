package com.livraison.services;

import java.util.List;
import java.util.Optional;

import com.livraison.entities.Task;

public interface TaskInterface {
public List<Task> getAllTasks();
public Task addOneTask(Task task,long employeeId, long teamId);
public void deleteOneTask(long id);
public Optional<Task> findOneTask(long id);

}
