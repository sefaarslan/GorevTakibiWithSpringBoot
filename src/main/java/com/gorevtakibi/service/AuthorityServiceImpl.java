package com.gorevtakibi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gorevtakibi.model.Authority;
import com.gorevtakibi.repository.AuthorityRepository;
@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	public void save(Authority authority) {
		authorityRepository.save(authority);
		
	}

	@Override
	public java.util.List<Authority> List() {
		return authorityRepository.findAll();
	}

	@Override
	public Authority findOne(int id) {
		// TODO Auto-generated method stub
		return authorityRepository.getOne(id);
	}
	

}
