package com.gorevtakibi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorevtakibi.model.Authority;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {

	
}
