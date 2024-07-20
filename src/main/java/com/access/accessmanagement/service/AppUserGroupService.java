package com.access.accessmanagement.service;

import java.util.List;

import com.access.accessmanagement.entity.AppUserGroup;


public interface AppUserGroupService {

	AppUserGroup saveUserGroup(AppUserGroup userGroup);

    List<AppUserGroup> fetchAllUserGroups();

    AppUserGroup getUserGroupsById(Integer id);

    AppUserGroup updateUserGroupsById(Integer id, AppUserGroup userGroup);

    String deleteUserGroupById(Integer id);
}
