package com.access.accessmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.accessmanagement.entity.AppGroup;


@Repository
public interface AppGroupRepository extends JpaRepository<AppGroup, Integer> {

	AppGroup findByName(String name);
	
	AppGroup findById(int id);
}
