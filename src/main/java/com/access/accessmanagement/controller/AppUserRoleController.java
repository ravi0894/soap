package com.access.accessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.access.accessmanagement.entity.AppRole;
import com.access.accessmanagement.entity.AppUser;
import com.access.accessmanagement.entity.AppUserRole;
import com.access.accessmanagement.exception.CustomException;
import com.access.accessmanagement.repository.AppRoleRepository;
import com.access.accessmanagement.repository.AppUserRepository;
import com.access.accessmanagement.repository.AppUserRoleRepository;
import com.access.accessmanagement.service.AppUserRoleService;
import com.access.accessmanagement.util.Mapper;

import access.management.AppUserRoleDelRequest;
import access.management.AppUserRoleDelResponse;
import access.management.AppUserRoleGetAllRequest;
import access.management.AppUserRoleGetAllResponse;
import access.management.AppUserRoleGetRequest;
import access.management.AppUserRoleGetResponse;
import access.management.AppUserRolePostRequest;
import access.management.AppUserRolePostResponse;
import access.management.AppUserRolePutRequest;
import access.management.AppUserRolePutResponse;
import access.management.AppUserRoleResponse;

@Endpoint
public class AppUserRoleController {
	
	@Autowired
    private AppUserRoleService appUserRoleService;
    
    @Autowired
    private AppUserRepository appUserRepository;
    
    @Autowired
    private AppRoleRepository appRoleRepository;
    
    @Autowired
    private AppUserRoleRepository appUserRoleRepository;
	    
    @PayloadRoot(namespace = "http://access/management", localPart = "AppUserRoleGetAllRequest")
	@ResponsePayload
	public AppUserRoleGetAllResponse getAllUserRoles(@RequestPayload AppUserRoleGetAllRequest request) {
		AppUserRoleGetAllResponse response = new AppUserRoleGetAllResponse();
		Mapper mapper = new Mapper();
		
		List<AppUserRole> appUserRoles =  appUserRoleService.fetchAllUserRoles();
		
		for (AppUserRole appUserRole : appUserRoles) {
			AppUserRoleResponse mapRole = mapper.mapAppUserRole(appUserRole);
			response.getAppUserRole().add(mapRole);
		}
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserRoleGetRequest")
	@ResponsePayload
	public AppUserRoleGetResponse getUserRole(@RequestPayload AppUserRoleGetRequest request) {
		AppUserRoleGetResponse response = new AppUserRoleGetResponse();
		Mapper mapper = new  Mapper();
		
		AppUserRole appUserRole =  appUserRoleService.getUserRolesById(request.getId());
	
		AppUserRoleResponse mapRole = mapper.mapAppUserRole(appUserRole);
		response.setAppUserRole(mapRole);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserRoleDelRequest")
	@ResponsePayload
	public AppUserRoleDelResponse deketeUserRole(@RequestPayload AppUserRoleDelRequest request) {
		AppUserRoleDelResponse response = new AppUserRoleDelResponse();	
		String message =  appUserRoleService.deleteUserRolesById(request.getId());
		response.setMessage(message);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserRolePostRequest")
	@ResponsePayload
	public AppUserRolePostResponse postUserRole(@RequestPayload AppUserRolePostRequest request) {
		
		AppUser appUser = appUserRepository.findByUsername(request.getUserId());
    	if(appUser == null)
    		throw new CustomException("userId "+request.getUserId()+" doesn't exists in AppUser table");
    	
    	AppRole appRole = appRoleRepository.findByName(request.getRoleId());
    	if(appRole == null)
    		throw new CustomException("RoleId "+request.getRoleId()+" doesn't exists in AppRole table");
    	
    	AppUserRole appUserRole = appUserRoleRepository.findByUserIdAndRoleId(request.getUserId(), request.getRoleId());
    	if(appUserRole != null)
    		throw new CustomException("userId "+request.getUserId()+" and RoleId "+request.getUserId()+" already exists in AppUserRole table");
    	
    	
		AppUserRolePostResponse response = new AppUserRolePostResponse();
		Mapper mapper = new Mapper();
		
		AppUserRole appUserrole =  appUserRoleService.saveUserRole(mapper.mapAppUserRoleReq(request));

		AppUserRoleResponse mapRole = mapper.mapAppUserRole(appUserrole);
		response.setAppUserRole(mapRole);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserRolePutRequest")
	@ResponsePayload
	public AppUserRolePutResponse putUserRole(@RequestPayload AppUserRolePutRequest request) {
		
		AppUser appUser = appUserRepository.findByUsername(request.getAppUserRole().getUserId());
		if(appUser == null)
    		throw new CustomException("userId "+request.getAppUserRole().getUserId()+" doesn't exists in AppUser table");
    	
    	AppRole appRole = appRoleRepository.findByName(request.getAppUserRole().getRoleId());
    	if(appRole == null)
    		throw new CustomException("RoleId "+request.getAppUserRole().getRoleId()+" doesn't exists in AppRole table");
    	
    	AppUserRole appUserRoleDb = appUserRoleRepository.findById(request.getAppUserRole().getId());
    	
		AppUserRolePutResponse response = new AppUserRolePutResponse();
		Mapper mapper = new Mapper();
		
		AppUserRole approle =  appUserRoleService.updateUserRolesById(request.getAppUserRole().getId(), mapper.mapAppUserRoleReqWithId(request,appUserRoleDb));

		AppUserRoleResponse mapRole = mapper.mapAppUserRole(approle);
		response.setAppUserRole(mapRole);
		return response;
	}
}
