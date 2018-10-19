package com.gorevtakibi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="Task")
public class Task {
	
	@Id
	private int id;
	
	@Column(name ="task_name")
	private String task_name;
	
	@Column(name ="task_duedate")
	private Date task_duedate;
	
	
	@Column(name="task_statement")
	private String task_statement;
	
	
	@Column(name="task_status")
	private String task_status;
	
	
	public Task() {
		  
	}
	 
	public Task(String task_status) {
		super();
	  	this.task_status = task_status;
	 }
	    
	   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	
	public String getTask_statement() {
		return task_statement;
	}
	public void setTask_statement(String task_statement) {
		this.task_statement = task_statement;
	}
	public String getTask_status() {
		return task_status;
	}
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public Date getTask_duedate() {
		return task_duedate;
	}

	public void setTask_duedate(Date task_duedate) {
		this.task_duedate = task_duedate;
	}


}
