package com.kajanan.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.kajanan.microservices.commonmodel.project.Project;

public interface ProjectServiceCon {
	
	List<Project> getAllProjectsByClient(@Param("projectClient") String projectClient);
	List<Project> getAllProjectsByStatus(@Param("status") String status);
	Project saveProject(Project project);
	Project updateProjectById(Project project);
	List<Project> getAllProjects();
	void deleteProjectById(int id);
	Project getProjectById(int id);
	
	public List<Project> getFilteredProjects(String status, String projectClient, String deadLine);
}
