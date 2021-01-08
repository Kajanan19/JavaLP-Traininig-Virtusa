package com.kajanan.microservices.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kajanan.microservices.commonmodel.task.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
	List<Task> findByProjectId(int id);
}
