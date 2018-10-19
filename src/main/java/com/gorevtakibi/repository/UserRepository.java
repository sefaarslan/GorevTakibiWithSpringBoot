package com.gorevtakibi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorevtakibi.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}