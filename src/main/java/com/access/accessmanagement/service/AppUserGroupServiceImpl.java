package com.access.accessmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.accessmanagement.entity.AppUserGroup;
import com.access.accessmanagement.repository.AppUserGroupRepository;

@Service
public class AppUserGroupServiceImpl implements AppUserGroupService{

	@Autowired
    private AppUserGroupRepository appUserGroupRepository;

	@Override
	public AppUserGroup saveUserGroup(AppUserGroup userGroup) {
		return appUserGroupRepository.save(userGroup);
	}

	@Override
	public List<AppUserGroup> fetchAllUserGroups() {
		List<AppUserGroup> allUserGroup = appUserGroupRepository.findAll();
	    return allUserGroup;
	}

	@Override
	public AppUserGroup getUserGroupsById(Integer id) {
		Optional<AppUserGroup> userGroup = appUserGroupRepository.findById(id);
        if (userGroup.isPresent()) {
            return userGroup.get();
        }
        return null;
	}

	@Override
	public AppUserGroup updateUserGroupsById(Integer id, AppUserGroup userGroup) {
		return appUserGroupRepository.save(userGroup);
	}

	@Override
	public String deleteUserGroupById(Integer id) {
		if (appUserGroupRepository.findById(id).isPresent()) {
			appUserGroupRepository.deleteById(id);
            return "User Group deleted successfully";
        }
        return "No such user group in the database";
	}

}
