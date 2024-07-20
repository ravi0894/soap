package com.access.accessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.access.accessmanagement.entity.AppGroup;
import com.access.accessmanagement.entity.AppUser;
import com.access.accessmanagement.entity.AppUserGroup;
import com.access.accessmanagement.exception.CustomException;
import com.access.accessmanagement.repository.AppGroupRepository;
import com.access.accessmanagement.repository.AppUserGroupRepository;
import com.access.accessmanagement.repository.AppUserRepository;
import com.access.accessmanagement.service.AppUserGroupService;
import com.access.accessmanagement.util.Mapper;

import access.management.AppUserGroupDelRequest;
import access.management.AppUserGroupDelResponse;
import access.management.AppUserGroupGetAllRequest;
import access.management.AppUserGroupGetAllResponse;
import access.management.AppUserGroupGetRequest;
import access.management.AppUserGroupGetResponse;
import access.management.AppUserGroupPostRequest;
import access.management.AppUserGroupPostResponse;
import access.management.AppUserGroupPutRequest;
import access.management.AppUserGroupPutResponse;
import access.management.AppUserGroupResponse;

@Endpoint
public class AppUserGroupController {
	
	@Autowired
    private AppUserGroupService appUserGroupService;
    
    @Autowired
    private AppUserRepository appUserRepository;
    
    @Autowired
    private AppUserGroupRepository appUserGroupRepository;
    
    @Autowired
    private AppGroupRepository appGroupRepository;
	    
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserGroupGetAllRequest")
	@ResponsePayload
	public AppUserGroupGetAllResponse getAllUserGroups(@RequestPayload AppUserGroupGetAllRequest request) {
		AppUserGroupGetAllResponse response = new AppUserGroupGetAllResponse();
		Mapper mapper = new Mapper();
		
		List<AppUserGroup> appUserGroups =  appUserGroupService.fetchAllUserGroups();
		
		for (AppUserGroup appUserGroup : appUserGroups) {
			AppUserGroupResponse mapGroup = mapper.mapAppUserGroup(appUserGroup);
			response.getAppUserGroup().add(mapGroup);
		}
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserGroupGetRequest")
	@ResponsePayload
	public AppUserGroupGetResponse getUserGroup(@RequestPayload AppUserGroupGetRequest request) {
		AppUserGroupGetResponse response = new AppUserGroupGetResponse();
		Mapper mapper = new  Mapper();
		
		AppUserGroup appUserGroup =  appUserGroupService.getUserGroupsById(request.getId());
	
		AppUserGroupResponse mapGroup = mapper.mapAppUserGroup(appUserGroup);
		response.setAppUserGroup(mapGroup);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserGroupDelRequest")
	@ResponsePayload
	public AppUserGroupDelResponse deketeUserGroup(@RequestPayload AppUserGroupDelRequest request) {
		AppUserGroupDelResponse response = new AppUserGroupDelResponse();	
		String message =  appUserGroupService.deleteUserGroupById(request.getId());
		response.setMessage(message);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserGroupPostRequest")
	@ResponsePayload
	public AppUserGroupPostResponse postUserGroup(@RequestPayload AppUserGroupPostRequest request) {
		
		AppUser appUser = appUserRepository.findByUsername(request.getUserId());
    	if(appUser == null)
    		throw new CustomException("userId "+request.getUserId()+" doesn't exists in AppUser table");
    	
    	AppGroup appGroup = appGroupRepository.findByName(request.getGroupId());
    	if(appGroup == null)
    		throw new CustomException("groupId "+request.getGroupId()+" doesn't exists in AppGroup table");
    	
    	AppUserGroup appUserGroup = appUserGroupRepository.findByUserIdAndGroupId(request.getUserId(), request.getGroupId());
    	if(appUserGroup != null)
    		throw new CustomException("userId "+request.getUserId()+" and groupId "+request.getUserId()+" already exists in AppUserGroup table");
    	
    	
		AppUserGroupPostResponse response = new AppUserGroupPostResponse();
		Mapper mapper = new Mapper();
		
		AppUserGroup appUsergroup =  appUserGroupService.saveUserGroup(mapper.mapAppUserGroupReq(request));

		AppUserGroupResponse mapGroup = mapper.mapAppUserGroup(appUsergroup);
		response.setAppUserGroup(mapGroup);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppUserGroupPutRequest")
	@ResponsePayload
	public AppUserGroupPutResponse putUserGroup(@RequestPayload AppUserGroupPutRequest request) {
		
		AppUser appUser = appUserRepository.findByUsername(request.getAppUserGroup().getUserId());
		if(appUser == null)
    		throw new CustomException("userId "+request.getAppUserGroup().getUserId()+" doesn't exists in AppUser table");
    	
    	AppGroup appGroup = appGroupRepository.findByName(request.getAppUserGroup().getGroupId());
    	if(appGroup == null)
    		throw new CustomException("groupId "+request.getAppUserGroup().getGroupId()+" doesn't exists in AppGroup table");
    	
    	AppUserGroup appUserGroupDb = appUserGroupRepository.findById(request.getAppUserGroup().getId());
    	
		AppUserGroupPutResponse response = new AppUserGroupPutResponse();
		Mapper mapper = new Mapper();
		
		AppUserGroup appgroup =  appUserGroupService.updateUserGroupsById(request.getAppUserGroup().getId(), mapper.mapAppUserGroupReqWithId(request,appUserGroupDb));

		AppUserGroupResponse mapGroup = mapper.mapAppUserGroup(appgroup);
		response.setAppUserGroup(mapGroup);
		return response;
	}
}
