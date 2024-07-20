package com.access.accessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.access.accessmanagement.entity.AppRole;
import com.access.accessmanagement.exception.CustomException;
import com.access.accessmanagement.repository.AppRoleRepository;
import com.access.accessmanagement.service.AppRoleService;
import com.access.accessmanagement.util.Mapper;

import access.management.AppRoleDelRequest;
import access.management.AppRoleDelResponse;
import access.management.AppRoleGetAllRequest;
import access.management.AppRoleGetAllResponse;
import access.management.AppRoleGetRequest;
import access.management.AppRoleGetResponse;
import access.management.AppRolePostRequest;
import access.management.AppRolePostResponse;
import access.management.AppRolePutRequest;
import access.management.AppRolePutResponse;
import access.management.AppRoleResponse;

@Endpoint
public class AppRoleController {
	
	 
	@Autowired
    private AppRoleRepository appRoleRepository;
	
	@Autowired
	private AppRoleService appRoleService;
	    
	@PayloadRoot(namespace = "http://access/management", localPart = "AppRoleGetAllRequest")
	@ResponsePayload
	public AppRoleGetAllResponse getAllRoles(@RequestPayload AppRoleGetAllRequest request) {
		AppRoleGetAllResponse response = new AppRoleGetAllResponse();
		Mapper mapper = new Mapper();
		
		List<AppRole> approles =  appRoleService.fetchAllRoles();
		
		for (AppRole appRole : approles) {
			AppRoleResponse mapRole = mapper.mapAppRole(appRole);
			response.getAppRole().add(mapRole);
		}
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppRoleGetRequest")
	@ResponsePayload
	public AppRoleGetResponse getRole(@RequestPayload AppRoleGetRequest request) {
		AppRoleGetResponse response = new AppRoleGetResponse();
		Mapper mapper = new  Mapper();
		
		AppRole approle =  appRoleService.getRoleById(request.getId());
	
		AppRoleResponse mapRole = mapper.mapAppRole(approle);
		response.setAppRole(mapRole);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppRoleDelRequest")
	@ResponsePayload
	public AppRoleDelResponse deketeRole(@RequestPayload AppRoleDelRequest request) {
		AppRoleDelResponse response = new AppRoleDelResponse();	
		String message =  appRoleService.deleteRoleById(request.getId());
		response.setMessage(message);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppRolePostRequest")
	@ResponsePayload
	public AppRolePostResponse postRole(@RequestPayload AppRolePostRequest request) {
		
		if(request.getName() =="")
    		throw new CustomException("role name shouldn't be empty");
    	
    	AppRole appRole = appRoleRepository.findByName(request.getName());
    	if(appRole != null)
    		throw new CustomException("role name "+request.getName()+" already exists in AppRole table");
    	
    	
    	AppRolePostResponse response = new AppRolePostResponse();
		Mapper mapper = new Mapper();
		
		AppRole approle =  appRoleService.saveRole(mapper.mapAppRoleReq(request));

		AppRoleResponse mapRole = mapper.mapAppRole(approle);
		response.setAppRole(mapRole);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppRolePutRequest")
	@ResponsePayload
	public AppRolePutResponse putRole(@RequestPayload AppRolePutRequest request) {
		
		if(request.getAppRole().getName() =="")
    		throw new CustomException("role name shouldn't be empty");
		
		AppRole appRoleDb = appRoleRepository.findById(request.getAppRole().getId());
    	if(appRoleDb == null)
    		throw new CustomException("role id "+request.getAppRole().getId()+" doesn't exists in AppRole table ");
    	
    	
		AppRolePutResponse response = new AppRolePutResponse();
		Mapper mapper = new Mapper();
		
		AppRole approle =  appRoleService.updateRoleById(request.getAppRole().getId(), mapper.mapAppRoleReqWithId(request,appRoleDb));

		AppRoleResponse mapRole = mapper.mapAppRole(approle);
		response.setAppRole(mapRole);
		return response;
	}
}
