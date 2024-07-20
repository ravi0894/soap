package com.access.accessmanagement.service;

import java.util.List;

import com.access.accessmanagement.entity.AppUser;


public interface AppUserService {

	AppUser saveUser(AppUser user);

    List<AppUser> fetchAllUsers();

    AppUser getUserById(Integer id);

    AppUser updateUserById(Integer id, AppUser user);

    String deleteUsertById(Integer id);
}
