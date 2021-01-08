package com.kajanan.microservices.dto;

import com.kajanan.microservices.commonmodel.project.Project;
import com.kajanan.microservices.commonmodel.task.Task;

public class TaskDTO {
	private Project project;
	private Task task;
	
	public TaskDTO() {
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
}
