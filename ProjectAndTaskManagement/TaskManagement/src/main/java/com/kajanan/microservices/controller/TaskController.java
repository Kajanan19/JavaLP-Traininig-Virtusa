package com.kajanan.microservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kajanan.microservices.commonmodel.task.Task;
import com.kajanan.microservices.dto.TaskDTO;
import com.kajanan.microservices.service.TaskService;


@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	
	
	@RequestMapping("/task")
	public List<Task> getAllTasks() {
		
		return taskService.getAllTasks();
	}
	
	@RequestMapping("/task/{id}") 
    public Optional<Task> getTask(@PathVariable int id) {
		return taskService.getTask(id);
    } 
	 
	@PostMapping(value="/task")
	Task createTask(@RequestBody Task task) {
		try {
			return taskService.savetask(task);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/task/{id}") 
	public void upateTask( @RequestBody Task task, @PathVariable int id) {
		taskService.updateTask(task, id); 
		
	} 
	
	 @RequestMapping(method = RequestMethod.DELETE, value = "/task/{id}") 
	 public void deleteTask(@PathVariable int id) {
		 taskService.deleteTask(id); 
	 }
	
	
	  
	 @GetMapping(value="/task", params = { "projectId" })
	List<Task> getAllTasksByProjectIds(@RequestParam("projectId") int id){
			return taskService.getAllTasksByProjectId(id);
		}
	 
	 

}
