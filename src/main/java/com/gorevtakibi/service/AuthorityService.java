package com.gorevtakibi.service;

import java.util.List;

import com.gorevtakibi.model.Authority;


public interface AuthorityService {
	void save(Authority authority);
	List<Authority> List();
	Authority findOne(int id);
	
}
