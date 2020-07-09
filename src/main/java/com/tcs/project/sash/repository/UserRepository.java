package com.tcs.project.sash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.project.sash.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	User findByUsernameAndPassword(String username, String password);
}
