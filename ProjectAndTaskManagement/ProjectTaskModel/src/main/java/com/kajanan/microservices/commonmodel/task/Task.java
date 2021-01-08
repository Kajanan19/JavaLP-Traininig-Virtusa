package com.kajanan.microservices.commonmodel.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue
	private int taskId;
	private String taskName;
	private int projectId;
	private float progress;
	private String member;
	
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public double getProgress() {
		return progress;
	}
	public void setProgress(float progress) {
		this.progress = progress;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", projectId=" + projectId + ", progress="
				+ progress + ", member=" + member + "]";
	}
	
	

}
