package com.kajanan.microservices.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kajanan.microservices.commonmodel.project.Project;



public interface ProjectRepository extends JpaRepository<Project, Integer> {
	List<Project> findByStatus(String isActive);
	List<Project> findByProjectClient(String projectClient);
	@Modifying
	@Transactional
	@Query("update Project p set p.projectName=?1 , p.isActive=?2 where projectId=?3")
	public int updateProjectById(String projectName, String isActive, int projectId);
}
