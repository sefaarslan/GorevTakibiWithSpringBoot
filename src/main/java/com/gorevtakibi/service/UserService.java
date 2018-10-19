package com.gorevtakibi.service;

import java.util.List;

import com.gorevtakibi.model.User;

public interface UserService {
	
	void save(User user);
	List<User> userList();
	User findOne(String username);
	
}
