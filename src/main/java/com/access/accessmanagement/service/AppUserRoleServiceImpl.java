package com.access.accessmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.accessmanagement.entity.AppUserRole;
import com.access.accessmanagement.repository.AppUserRoleRepository;

@Service
public class AppUserRoleServiceImpl implements AppUserRoleService{

	@Autowired
    private AppUserRoleRepository appUserRoleRepository;


	@Override
	public AppUserRole saveUserRole(AppUserRole userRole) {
		return appUserRoleRepository.save(userRole);
	}

	@Override
	public List<AppUserRole> fetchAllUserRoles() {
		List<AppUserRole> allUserRoles = appUserRoleRepository.findAll();
	    return allUserRoles;
	}

	@Override
	public AppUserRole getUserRolesById(Integer id) {
		Optional<AppUserRole> userRole = appUserRoleRepository.findById(id);
        if (userRole.isPresent()) {
            return userRole.get();
        }
        return null;
	}

	@Override
	public AppUserRole updateUserRolesById(Integer id, AppUserRole userRole) {
		return appUserRoleRepository.save(userRole);
	}

	@Override
	public String deleteUserRolesById(Integer id) {
		if (appUserRoleRepository.findById(id).isPresent()) {
			appUserRoleRepository.deleteById(id);
            return "User Role deleted successfully";
        }
        return "No such user role in the database";
	}

}
