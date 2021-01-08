package com.kajanan.microservices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kajanan.microservices.commonmodel.project.Project;
import com.kajanan.microservices.commonmodel.task.Task;
import com.kajanan.microservices.repository.TaskRepository;

@Service
public class TaskService implements TaskServiceCon{

	@Autowired
	private TaskRepository taskRepository;
	
	@Bean
	RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	};
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Task> getAllTasks() {
		List<Task>taskList=new ArrayList<>();
		// TODO Auto-generated method stub
		taskRepository.findAll()
		.forEach(taskList::add);
		
		return taskList;
	}
	
	
	@Override
	public Optional<Task> getTask(int id) {
		return taskRepository.findById(id);
	}
	
	

	
	@Override
	public void updateTask(Task taskReceievd, int id) {
		// TODO Auto-generated method stub
		 taskRepository.save(taskReceievd);	
	}
	
	@Override
	public void deleteTask(int id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);
	}



	@Override
	public List<Task> getAllTasksByProjectId(int id) {
		// TODO Auto-generated method stub
		return taskRepository.findByProjectId(id);
	}


	@Override
	public Task savetask(Task task) throws Exception {
		// TODO Auto-generated method stub
		Project project= getProjectById(task.getProjectId());
		if(project==null) {
			throw new Exception();
			
		}else {
			return taskRepository.save(task);
		}
	}
	
	private Project getProjectById(int id) {
		 Project project = restTemplate.getForObject("http://localhost:8080/project/"+id, Project.class);
		 System.out.println(project);
		 return project;
	}


	


	
}
