package com.access.accessmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.accessmanagement.entity.AppGroup;
import com.access.accessmanagement.repository.AppGroupRepository;


@Service
public class AppGroupServiceImpl implements AppGroupService{

	@Autowired
    private AppGroupRepository appGroupRepository;
	

	@Override
	public AppGroup saveGroup(AppGroup group) {
		return appGroupRepository.save(group);
	}

	@Override
	public List<AppGroup> fetchAllGroups() {
		List<AppGroup> allGroups = appGroupRepository.findAll();
	    return allGroups;
	}

	@Override
	public AppGroup getGroupById(Integer id) {
		Optional<AppGroup> group = appGroupRepository.findById(id);
        if (group.isPresent()) {
            return group.get();
        }
        return null;
	}

	@Override
	public AppGroup updateGroupById(Integer id, AppGroup group) {
		return appGroupRepository.save(group);
	}

	@Override
	public String deleteGroupById(Integer id) {
		if (appGroupRepository.findById(id).isPresent()) {
			appGroupRepository.deleteById(id);
            return "Group deleted successfully";
        }
        return "No such Group in the database";
	}

}
