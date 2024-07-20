package com.access.accessmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.accessmanagement.entity.AppRole;
import com.access.accessmanagement.repository.AppRoleRepository;

@Service
public class AppRoleServiceImpl implements AppRoleService{

	@Autowired
    private AppRoleRepository appRoleRepository;

	@Override
	public AppRole saveRole(AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	public List<AppRole> fetchAllRoles() {
		List<AppRole> allROles = appRoleRepository.findAll();
	    return allROles;
	}

	@Override
	public AppRole getRoleById(Integer id) {
		Optional<AppRole> role = appRoleRepository.findById(id);
        if (role.isPresent()) {
            return role.get();
        }
        return null;
	}

	@Override
	public AppRole updateRoleById(Integer id, AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	public String deleteRoleById(Integer id) {
		if (appRoleRepository.findById(id).isPresent()) {
			appRoleRepository.deleteById(id);
            return "Role deleted successfully";
        }
        return "No such Role in the database";
	}

}
