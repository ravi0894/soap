package com.access.accessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.access.accessmanagement.entity.AppGroup;
import com.access.accessmanagement.exception.CustomException;
import com.access.accessmanagement.repository.AppGroupRepository;
import com.access.accessmanagement.service.AppGroupService;
import com.access.accessmanagement.util.Mapper;

import access.management.AppGroupDelRequest;
import access.management.AppGroupDelResponse;
import access.management.AppGroupGetAllRequest;
import access.management.AppGroupGetAllResponse;
import access.management.AppGroupGetRequest;
import access.management.AppGroupGetResponse;
import access.management.AppGroupPostRequest;
import access.management.AppGroupPostResponse;
import access.management.AppGroupPutRequest;
import access.management.AppGroupPutResponse;
import access.management.AppGroupResponse;

@Endpoint
public class AppGroupController {
	
	 @Autowired
	 private AppGroupService appGroupService;
	 
	 @Autowired
	 private AppGroupRepository appGroupRepository;
	    
	@PayloadRoot(namespace = "http://access/management", localPart = "AppGroupGetAllRequest")
	@ResponsePayload
	public AppGroupGetAllResponse getAllGroups(@RequestPayload AppGroupGetAllRequest request) {
		AppGroupGetAllResponse response = new AppGroupGetAllResponse();
		Mapper mapper = new Mapper();
		
		List<AppGroup> appgroups =  appGroupService.fetchAllGroups();
		
		for (AppGroup appgroup : appgroups) {
			AppGroupResponse mapGroup = mapper.mapAppGroup(appgroup);
			response.getAppGroup().add(mapGroup);
		}
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppGroupGetRequest")
	@ResponsePayload
	public AppGroupGetResponse getGroup(@RequestPayload AppGroupGetRequest request) {
		AppGroupGetResponse response = new AppGroupGetResponse();
		Mapper mapper = new  Mapper();
		
		AppGroup appgroup =  appGroupService.getGroupById(request.getId());
	
		AppGroupResponse mapGroup = mapper.mapAppGroup(appgroup);
		response.setAppGroup(mapGroup);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppGroupDelRequest")
	@ResponsePayload
	public AppGroupDelResponse deketeGroup(@RequestPayload AppGroupDelRequest request) {
		AppGroupDelResponse response = new AppGroupDelResponse();	
		String message =  appGroupService.deleteGroupById(request.getId());
		response.setMessage(message);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppGroupPostRequest")
	@ResponsePayload
	public AppGroupPostResponse postGroup(@RequestPayload AppGroupPostRequest request) {
		
		if(request.getName() =="")
    		throw new CustomException("group name shouldn't be empty");
    	
    	AppGroup appGroup = appGroupRepository.findByName(request.getName());
    	if(appGroup != null)
    		throw new CustomException("group name "+request.getName()+" already exists in AppGroup table");
    	
    	
		AppGroupPostResponse response = new AppGroupPostResponse();
		Mapper mapper = new Mapper();
		
		AppGroup appgroup =  appGroupService.saveGroup(mapper.mapAppGroupReq(request));

		AppGroupResponse mapGroup = mapper.mapAppGroup(appgroup);
		response.setAppGroup(mapGroup);
		return response;
	}
	
	@PayloadRoot(namespace = "http://access/management", localPart = "AppGroupPutRequest")
	@ResponsePayload
	public AppGroupPutResponse putGroup(@RequestPayload AppGroupPutRequest request) {
		
		if(request.getAppGroup().getName() =="")
    		throw new CustomException("group name shouldn't be empty");
		
		AppGroup appRoleDb = appGroupRepository.findById(request.getAppGroup().getId());
    	if(appRoleDb == null)
    		throw new CustomException("id "+request.getAppGroup().getId()+" doesn't exists in AppGroup table");
    	
    	
		AppGroupPutResponse response = new AppGroupPutResponse();
		Mapper mapper = new Mapper();
		
		AppGroup appgroup =  appGroupService.updateGroupById(request.getAppGroup().getId(), mapper.mapAppGroupReqWithId(request,appRoleDb));

		AppGroupResponse mapGroup = mapper.mapAppGroup(appgroup);
		response.setAppGroup(mapGroup);
		return response;
	}
}
