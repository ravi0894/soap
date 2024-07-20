package com.access.accessmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.accessmanagement.entity.AppUserRole;

@Repository
public interface AppUserRoleRepository extends JpaRepository<AppUserRole, Integer> {

	AppUserRole findByUserIdAndRoleId(String userId, String roleId);
	AppUserRole findById(int id);
}
