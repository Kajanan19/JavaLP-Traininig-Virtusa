package com.kajanan.microservices.commonmodel.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	public Project() {
		
	}
	
	public Project( String projectName, String isActive, Date endDate) {
		
		this.projectName = projectName;
		this.isActive = isActive;
		this.endDate = endDate;
	}
	
	public Project( String projectName, String isActive, String endDate) {
	
		this.projectName = projectName;
		this.isActive = isActive;
		try {
			this.endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		} catch (ParseException e) {
			this.endDate=null;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	private String projectName;
	String isActive;
	Date endDate;
	String projectDesription;
	
	
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

	public String getProjectDesription() {
		return projectDesription;
	}

	public void setProjectDesription(String projectDesription) {
		this.projectDesription = projectDesription;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", isActive=" + isActive + ", deadLine="
				+ endDate + "]";
	}
	
	
	
}

