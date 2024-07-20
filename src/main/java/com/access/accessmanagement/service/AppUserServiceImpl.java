package com.access.accessmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.accessmanagement.entity.AppUser;
import com.access.accessmanagement.repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService{

	@Autowired
    private AppUserRepository appUserRepository;
	
	@Override
	public AppUser saveUser(AppUser user) {
		return appUserRepository.save(user);
	}

	@Override
	public List<AppUser> fetchAllUsers() {
		List<AppUser> allUsers = appUserRepository.findAll();
	     return allUsers;
	}

	@Override
	public AppUser getUserById(Integer id) {
		Optional<AppUser> user = appUserRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
	}

	@Override
	public AppUser updateUserById(Integer id, AppUser user) {
		
		return appUserRepository.save(user);
		
//		  Optional<AppUser> user1 = appUserRepository.findById(id);
//		  
//		  if (user1.isPresent()) 
//		  {
//			  AppUser originalUser = user1.get();
//
//	            if (Objects.nonNull(user.getUsername()) && !"".equalsIgnoreCase(user.getUsername())) {
//	            	originalUser.setUsername(user.getUsername());
//	            }
//	            if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
//	            	originalUser.setEmail(user.getEmail());
//	            }
//	            if (Objects.nonNull(user.getPasswordHash()) && !"".equalsIgnoreCase(user.getPasswordHash())) {
//	            	originalUser.setPasswordHash(user.getPasswordHash());
//	            }
//	            if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
//	            	originalUser.setFirstName(user.getFirstName());
//	            }
//	            if (Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
//	            	originalUser.setLastName(user.getLastName());
//	            }
//	            if (Objects.nonNull(user.getMiddleName()) && !"".equalsIgnoreCase(user.getMiddleName())) {
//	            	originalUser.setMiddleName(user.getMiddleName());
//	            }
//	            if (Objects.nonNull(user.getNickname()) && !"".equalsIgnoreCase(user.getNickname())) {
//	            	originalUser.setNickname(user.getNickname());
//	            }
//	            if (Objects.nonNull(user.getDateOfBirth())) {
//	            	originalUser.setDateOfBirth(user.getDateOfBirth());
//	            }
//	           
//	            return appUserRepository.save(originalUser);
//	        }
//		 
//        return null;
	}

	@Override
	public String deleteUsertById(Integer id) {
		if (appUserRepository.findById(id).isPresent()) {
			appUserRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "No such user in the database";
	}

}
