package com.access.accessmanagement.service;

import java.util.List;

import com.access.accessmanagement.entity.AppRole;


public interface AppRoleService {

	AppRole saveRole(AppRole role);

    List<AppRole> fetchAllRoles();

    AppRole getRoleById(Integer id);

    AppRole updateRoleById(Integer id, AppRole role);

    String deleteRoleById(Integer id);
}
