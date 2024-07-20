package com.access.accessmanagement.service;

import java.util.List;

import com.access.accessmanagement.entity.AppUserRole;


public interface AppUserRoleService {

	AppUserRole saveUserRole(AppUserRole userRole);

    List<AppUserRole> fetchAllUserRoles();

    AppUserRole getUserRolesById(Integer id);

    AppUserRole updateUserRolesById(Integer id, AppUserRole userRole);

    String deleteUserRolesById(Integer id);
}
