package com.access.accessmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.accessmanagement.entity.AppUserGroup;

@Repository
public interface AppUserGroupRepository extends JpaRepository<AppUserGroup, Integer> {

	AppUserGroup findByUserIdAndGroupId(String userId, String groupId);
	
	AppUserGroup findById(int id);
}
