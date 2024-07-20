package com.access.accessmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.accessmanagement.entity.AppRole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {
	
	AppRole findByName(String name);
	
	AppRole findById(int id);

}
