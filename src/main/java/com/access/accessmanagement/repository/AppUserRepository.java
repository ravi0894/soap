package com.access.accessmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.accessmanagement.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	  AppUser findByUsername(String username);
	  AppUser findById(int id);
}
