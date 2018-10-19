package com.gorevtakibi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gorevtakibi.model.User;
import com.gorevtakibi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(String username) {
		return userRepository.getOne(username);
	}

	

	
	
	
	
}
