package com.access.accessmanagement.service;

import java.util.List;

import com.access.accessmanagement.entity.AppGroup;



public interface AppGroupService {

	AppGroup saveGroup(AppGroup group);

    List<AppGroup> fetchAllGroups();

    AppGroup getGroupById(Integer id);

    AppGroup updateGroupById(Integer id, AppGroup group);

    String deleteGroupById(Integer id);
}
