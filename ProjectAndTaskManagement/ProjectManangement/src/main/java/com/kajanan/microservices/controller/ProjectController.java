package com.kajanan.microservices.controller;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.kajanan.microservices.commonmodel.project.Project;
import com.kajanan.microservices.commonmodel.task.Task;
import com.kajanan.microservices.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectService;

	@PostMapping(value = "/project")
	public ResponseEntity<Project> addProject(@RequestBody Project project) {
		return new ResponseEntity<Project>(projectService.saveProject(project), HttpStatus.CREATED);
	}

	@GetMapping(value = "/project/{id}")
	public Project getProjectById(@PathVariable("id") int id) {
		return projectService.getProjectById(id);
	}

	@GetMapping(value = "/project")
	public List<Project> getAllProjects() {

		return projectService.getAllProjects();

	}

	@PatchMapping(value = "/project/{id}")
	public Project updateProject(@PathVariable int id, @RequestBody Project project) {
		return projectService.updateProjectById(project);
	}

	@DeleteMapping(value = "/project/{id}")
	public ResponseEntity<Integer> deleteProjectById(@PathVariable("id") int id) {
		projectService.deleteProjectById(id);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}

	@GetMapping(value = "/project", params = { "isActive" })
	public List<Project> getProjectsByStatus(@RequestParam("isActive") String isActive) {
		return projectService.getAllProjectsByStatus(isActive);

	}

	@GetMapping(value = "/project", params = { "projectClient" })
	public List<Project> getProjectsByClient(@RequestParam("projectClient") String projectClient) {
		return projectService.getAllProjectsByClient(projectClient);

	}

	@GetMapping(value = "/project/{id}/tasks")
	public List<Task> getAllTaskOfProject(@PathVariable("id") Integer id) {
		return projectService.getAllTaskOfProject(id);
	}


}
