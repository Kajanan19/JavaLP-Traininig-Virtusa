package com.kajanan.microservices.service;

import java.util.List;
import java.util.Optional;

import com.kajanan.microservices.commonmodel.project.Project;
import com.kajanan.microservices.commonmodel.task.Task;

public interface TaskServiceCon {
	public List<Task> getAllTasks();
	public Optional<Task> getTask(int id);
	public void updateTask(Task taskReceievd, int id);
	public void deleteTask(int id);
    Task savetask(Task task) throws Exception;
	public List<Task> getAllTasksByProjectId(int id);
}
