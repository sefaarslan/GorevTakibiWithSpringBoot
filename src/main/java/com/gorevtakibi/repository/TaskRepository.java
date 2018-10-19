package com.gorevtakibi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorevtakibi.model.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {

} 