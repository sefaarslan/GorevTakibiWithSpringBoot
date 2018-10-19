package com.gorevtakibi.service;

import java.util.List;

import com.gorevtakibi.model.Task;


public interface TaskService {
	
	void save(Task task);
	List<Task> getTaskList();
	Task findOne(int id);
    void delete(int id);
	
}
