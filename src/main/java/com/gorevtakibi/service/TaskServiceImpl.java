package com.gorevtakibi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gorevtakibi.model.Task;
import com.gorevtakibi.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired 
	private TaskRepository taskRepository;

	@Override
	public void save(Task task) {
		taskRepository.save(task);
		
	}

	@Override
	public List<Task> getTaskList() {
		return taskRepository.findAll();
	}

	@Override
	public Task findOne(int id) {
		return taskRepository.getOne(id);
	}

	@Override
	public void delete(int id) {
		taskRepository.delete(id);		
	}



	

}
