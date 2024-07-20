package com.access.accessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.access.accessmanagement.entity.AppUser;
import com.access.accessmanagement.exception.CustomException;
import com.access.accessmanagement.repository.AppUserRepository;
import com.access.accessmanagement.service.AppUserService;
import com.access.accessmanagement.util.Mapper;

import access.management.AppUserDelRequest;
import access.management.AppUserDelResponse;
import access.management.AppUserGetAllRequest;
import access.management.AppUserGetAllResponse;
import access.management.AppUserGetRequest;
import access.management.AppUserGetResponse;
import access.management.AppUserPostRequest;
import access.management.AppUserPostResponse;
import access.management.AppUserPutRequest;
import access.management.AppUserPutResponse;
import access.management.AppUserResponse;

@Endpoint
public class AppUserController {
	
	@Autowired
    private AppUserService appUserService;
    
    @Autowired
    private AppUserRepository appUserRepository;
	    
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserGetAllRequest")
	@ResponsePayload
	public AppUserGetAllResponse getAllUsers(@RequestPayload AppUserGetAllRequest request) {
		AppUserGetAllResponse response = new AppUserGetAllResponse();
		Mapper mapper = new Mapper();
		
		List<AppUser> appUsers =  appUserService.fetchAllUsers();
		
		for (AppUser appUser : appUsers) {
			AppUserResponse mapUser = mapper.mapAppUser(appUser);
			response.getAppUser().add(mapUser);
		}
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserGetRequest")
	@ResponsePayload
	public AppUserGetResponse getUser(@RequestPayload AppUserGetRequest request) {
		AppUserGetResponse response = new AppUserGetResponse();
		Mapper mapper = new  Mapper();
		
		AppUser appUser =  appUserService.getUserById(request.getId());
	
		AppUserResponse mapUser = mapper.mapAppUser(appUser);
		response.setAppUser(mapUser);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserDelRequest")
	@ResponsePayload
	public AppUserDelResponse deketeUser(@RequestPayload AppUserDelRequest request) {
		AppUserDelResponse response = new AppUserDelResponse();	
		String message =  appUserService.deleteUsertById(request.getId());
		response.setMessage(message);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserPostRequest")
	@ResponsePayload
	public AppUserPostResponse postUser(@RequestPayload AppUserPostRequest request) {
		
		if(request.getUsername() =="")
    		throw new CustomException("username name shouldn't be empty");
    	
		AppUser appUser = appUserRepository.findByUsername(request.getUsername());
    	if(appUser != null)
    		throw new CustomException("user name "+request.getUsername()+" already exists in AppUser table");
    	
		AppUserPostResponse response = new AppUserPostResponse();
		Mapper mapper = new Mapper();
		
		AppUser appuser =  appUserService.saveUser(mapper.mapAppUserReq(request));

		AppUserResponse mapUser = mapper.mapAppUser(appuser);
		response.setAppUser(mapUser);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserPutRequest")
	@ResponsePayload
	public AppUserPutResponse putGroup(@RequestPayload AppUserPutRequest request) {
		
		if(request.getAppUser().getUsername() =="")
    		throw new CustomException("user name shouldn't be empty");
		
		AppUser appUserDb = appUserRepository.findById(request.getAppUser().getId());
    	if(appUserDb == null)
    		throw new CustomException("id "+request.getAppUser().getId()+" doesn't exists in AppUser table");
    	
    	
		AppUserPutResponse response = new AppUserPutResponse();
		Mapper mapper = new Mapper();
		
		AppUser appuser =  appUserService.updateUserById(request.getAppUser().getId(), mapper.mapAppUserReqWithId(request,appUserDb));

		AppUserResponse mapUser = mapper.mapAppUser(appuser);
		response.setAppUser(mapUser);
		return response;
	}
}
