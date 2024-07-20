package com.access.accessmanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.access.accessmanagement.entity.AppGroup;
import com.access.accessmanagement.entity.AppRole;
import com.access.accessmanagement.entity.AppUser;
import com.access.accessmanagement.entity.AppUserGroup;
import com.access.accessmanagement.entity.AppUserRole;

import access.management.AppGroupPostRequest;
import access.management.AppGroupPutRequest;
import access.management.AppGroupResponse;
import access.management.AppRolePostRequest;
import access.management.AppRolePutRequest;
import access.management.AppRoleResponse;
import access.management.AppUserGroupPostRequest;
import access.management.AppUserGroupPutRequest;
import access.management.AppUserGroupResponse;
import access.management.AppUserPostRequest;
import access.management.AppUserPutRequest;
import access.management.AppUserResponse;
import access.management.AppUserRolePostRequest;
import access.management.AppUserRolePutRequest;
import access.management.AppUserRoleResponse;

public class Mapper {

	public AppGroupResponse mapAppGroup(AppGroup appgroup) {
		AppGroupResponse appGroupResponse = new AppGroupResponse();
		
		appGroupResponse.setId(appgroup.getId());
		appGroupResponse.setName(appgroup.getName());
		appGroupResponse.setDescription(appgroup.getDescription());
		appGroupResponse.setIsActive(appgroup.getIsActive());
		appGroupResponse.setIsSystemGroup(appgroup.getIsSystemGroup());
		if(appgroup.getCreatedBy()!=null) 
			appGroupResponse.setCreatedBy(appgroup.getCreatedBy());
		if(appgroup.getUpdatedBy()!=null)
			appGroupResponse.setUpdatedBy(appgroup.getUpdatedBy());
		
		appGroupResponse.setCustomAttribute1(appgroup.getCustomAttribute1());
		appGroupResponse.setCustomAttribute2(appgroup.getCustomAttribute2());
		appGroupResponse.setCustomAttribute3(appgroup.getCustomAttribute3());
		appGroupResponse.setCustomAttribute4(appgroup.getCustomAttribute4());
		appGroupResponse.setCustomAttribute5(appgroup.getCustomAttribute5());
		appGroupResponse.setCustomAttribute6(appgroup.getCustomAttribute6());
		appGroupResponse.setCustomAttribute7(appgroup.getCustomAttribute7());
		appGroupResponse.setCustomAttribute8(appgroup.getCustomAttribute8());
		appGroupResponse.setCustomAttribute9(appgroup.getCustomAttribute9());
		appGroupResponse.setCustomAttribute10(appgroup.getCustomAttribute10());
		
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
        XMLGregorianCalendar xmlGregorianCalendar;
		try {
			gregorianCalendar.setTime(appgroup.getCreatedAt());
			
			xmlGregorianCalendar = DatatypeFactory
			        .newInstance()
			        .newXMLGregorianCalendar(gregorianCalendar);
			
			appGroupResponse.setCreatedAt(xmlGregorianCalendar);
			
			
			gregorianCalendar.setTime(appgroup.getUpdatedAt());
			
			xmlGregorianCalendar = DatatypeFactory
			        .newInstance()
			        .newXMLGregorianCalendar(gregorianCalendar);
			appGroupResponse.setUpdatedAt(xmlGregorianCalendar);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		return appGroupResponse;
	}
	
	public AppGroup mapAppGroupReq(AppGroupPostRequest appGroupPostRequest) {
		AppGroup appGroup = new AppGroup();
		
		appGroup.setName(appGroupPostRequest.getName());
		appGroup.setDescription(appGroupPostRequest.getDescription());
		appGroup.setIsActive(appGroupPostRequest.isIsActive());
		appGroup.setIsSystemGroup(appGroupPostRequest.isIsSystemGroup());
		appGroup.setCreatedBy(appGroupPostRequest.getCreatedBy());
		appGroup.setUpdatedBy(appGroupPostRequest.getUpdatedBy());
		
		appGroup.setCustomAttribute1(appGroupPostRequest.getCustomAttribute1());
		appGroup.setCustomAttribute2(appGroupPostRequest.getCustomAttribute2());
		appGroup.setCustomAttribute3(appGroupPostRequest.getCustomAttribute3());
		appGroup.setCustomAttribute4(appGroupPostRequest.getCustomAttribute4());
		appGroup.setCustomAttribute5(appGroupPostRequest.getCustomAttribute5());
		appGroup.setCustomAttribute6(appGroupPostRequest.getCustomAttribute6());
		appGroup.setCustomAttribute7(appGroupPostRequest.getCustomAttribute7());
		appGroup.setCustomAttribute8(appGroupPostRequest.getCustomAttribute8());
		appGroup.setCustomAttribute9(appGroupPostRequest.getCustomAttribute9());
		appGroup.setCustomAttribute10(appGroupPostRequest.getCustomAttribute10());
		appGroup.setCreatedAt(new Date());
		appGroup.setUpdatedAt(new Date());
		
		return appGroup;
	}
	
	public AppGroup mapAppGroupReqWithId(AppGroupPutRequest appGroupPutRequest,AppGroup appRoleDb) {
		AppGroup appGroup = new AppGroup();
		
		appGroup.setId(appGroupPutRequest.getAppGroup().getId());
		appGroup.setName(appGroupPutRequest.getAppGroup().getName());
		appGroup.setDescription(appGroupPutRequest.getAppGroup().getDescription());
		appGroup.setIsActive(appGroupPutRequest.getAppGroup().isIsActive());
		appGroup.setIsSystemGroup(appGroupPutRequest.getAppGroup().isIsSystemGroup());
		appGroup.setCreatedBy(appGroupPutRequest.getAppGroup().getCreatedBy());
		appGroup.setUpdatedBy(appGroupPutRequest.getAppGroup().getUpdatedBy());
		
		appGroup.setCustomAttribute1(appGroupPutRequest.getAppGroup().getCustomAttribute1());
		appGroup.setCustomAttribute2(appGroupPutRequest.getAppGroup().getCustomAttribute2());
		appGroup.setCustomAttribute3(appGroupPutRequest.getAppGroup().getCustomAttribute3());
		appGroup.setCustomAttribute4(appGroupPutRequest.getAppGroup().getCustomAttribute4());
		appGroup.setCustomAttribute5(appGroupPutRequest.getAppGroup().getCustomAttribute5());
		appGroup.setCustomAttribute6(appGroupPutRequest.getAppGroup().getCustomAttribute6());
		appGroup.setCustomAttribute7(appGroupPutRequest.getAppGroup().getCustomAttribute7());
		appGroup.setCustomAttribute8(appGroupPutRequest.getAppGroup().getCustomAttribute8());
		appGroup.setCustomAttribute9(appGroupPutRequest.getAppGroup().getCustomAttribute9());
		appGroup.setCustomAttribute10(appGroupPutRequest.getAppGroup().getCustomAttribute10());
		appGroup.setUpdatedAt(new Date());
		appGroup.setCreatedAt(appRoleDb.getCreatedAt());
		
		return appGroup;
	}
	
	
	public AppRoleResponse mapAppRole(AppRole approle) {
		AppRoleResponse appRoleResponse = new AppRoleResponse();
		
		appRoleResponse.setId(approle.getId());
		appRoleResponse.setName(approle.getName());
		appRoleResponse.setDescription(approle.getDescription());
		appRoleResponse.setIsActive(approle.getIsActive());
		appRoleResponse.setIsSystemRole(approle.getIsSystemRole());
		if(approle.getCreatedBy()!=null) 
			appRoleResponse.setCreatedBy(approle.getCreatedBy());
		if(approle.getUpdatedBy()!=null)
			appRoleResponse.setUpdatedBy(approle.getUpdatedBy());
		
		appRoleResponse.setCustomAttribute1(approle.getCustomAttribute1());
		appRoleResponse.setCustomAttribute2(approle.getCustomAttribute2());
		appRoleResponse.setCustomAttribute3(approle.getCustomAttribute3());
		appRoleResponse.setCustomAttribute4(approle.getCustomAttribute4());
		appRoleResponse.setCustomAttribute5(approle.getCustomAttribute5());
		appRoleResponse.setCustomAttribute6(approle.getCustomAttribute6());
		appRoleResponse.setCustomAttribute7(approle.getCustomAttribute7());
		appRoleResponse.setCustomAttribute8(approle.getCustomAttribute8());
		appRoleResponse.setCustomAttribute9(approle.getCustomAttribute9());
		appRoleResponse.setCustomAttribute10(approle.getCustomAttribute10());
		
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
        XMLGregorianCalendar xmlGregorianCalendar;
		try {
			gregorianCalendar.setTime(approle.getCreatedAt());
			
			xmlGregorianCalendar = DatatypeFactory
			        .newInstance()
			        .newXMLGregorianCalendar(gregorianCalendar);
			
			appRoleResponse.setCreatedAt(xmlGregorianCalendar);
			
			
			gregorianCalendar.setTime(approle.getUpdatedAt());
			
			xmlGregorianCalendar = DatatypeFactory
			        .newInstance()
			        .newXMLGregorianCalendar(gregorianCalendar);
			appRoleResponse.setUpdatedAt(xmlGregorianCalendar);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		return appRoleResponse;
	}
	
	public AppRole mapAppRoleReq(AppRolePostRequest appRolePostRequest) {
		AppRole appRole = new AppRole();
		
		appRole.setName(appRolePostRequest.getName());
		appRole.setDescription(appRolePostRequest.getDescription());
		appRole.setIsActive(appRolePostRequest.isIsActive());
		appRole.setIsSystemRole(appRolePostRequest.isIsSystemRole());
		appRole.setCreatedBy(appRolePostRequest.getCreatedBy());
		appRole.setUpdatedBy(appRolePostRequest.getUpdatedBy());
		
		appRole.setCustomAttribute1(appRolePostRequest.getCustomAttribute1());
		appRole.setCustomAttribute2(appRolePostRequest.getCustomAttribute2());
		appRole.setCustomAttribute3(appRolePostRequest.getCustomAttribute3());
		appRole.setCustomAttribute4(appRolePostRequest.getCustomAttribute4());
		appRole.setCustomAttribute5(appRolePostRequest.getCustomAttribute5());
		appRole.setCustomAttribute6(appRolePostRequest.getCustomAttribute6());
		appRole.setCustomAttribute7(appRolePostRequest.getCustomAttribute7());
		appRole.setCustomAttribute8(appRolePostRequest.getCustomAttribute8());
		appRole.setCustomAttribute9(appRolePostRequest.getCustomAttribute9());
		appRole.setCustomAttribute10(appRolePostRequest.getCustomAttribute10());
		appRole.setCreatedAt(new Date());
		appRole.setUpdatedAt(new Date());
		
		return appRole;
	}
	
	public AppRole mapAppRoleReqWithId(AppRolePutRequest appRolePutRequest, AppRole appRoleDb) {
		AppRole appRole = new AppRole();
		
		appRole.setId(appRolePutRequest.getAppRole().getId());
		appRole.setName(appRolePutRequest.getAppRole().getName());
		appRole.setDescription(appRolePutRequest.getAppRole().getDescription());
		appRole.setIsActive(appRolePutRequest.getAppRole().isIsActive());
		appRole.setIsSystemRole(appRolePutRequest.getAppRole().isIsSystemRole());
		appRole.setCreatedBy(appRolePutRequest.getAppRole().getCreatedBy());
		appRole.setUpdatedBy(appRolePutRequest.getAppRole().getUpdatedBy());
		
		appRole.setCustomAttribute1(appRolePutRequest.getAppRole().getCustomAttribute1());
		appRole.setCustomAttribute2(appRolePutRequest.getAppRole().getCustomAttribute2());
		appRole.setCustomAttribute3(appRolePutRequest.getAppRole().getCustomAttribute3());
		appRole.setCustomAttribute4(appRolePutRequest.getAppRole().getCustomAttribute4());
		appRole.setCustomAttribute5(appRolePutRequest.getAppRole().getCustomAttribute5());
		appRole.setCustomAttribute6(appRolePutRequest.getAppRole().getCustomAttribute6());
		appRole.setCustomAttribute7(appRolePutRequest.getAppRole().getCustomAttribute7());
		appRole.setCustomAttribute8(appRolePutRequest.getAppRole().getCustomAttribute8());
		appRole.setCustomAttribute9(appRolePutRequest.getAppRole().getCustomAttribute9());
		appRole.setCustomAttribute10(appRolePutRequest.getAppRole().getCustomAttribute10());
		appRole.setCreatedAt(appRoleDb.getCreatedAt());
		appRole.setUpdatedAt(new Date());
		
		return appRole;
	}

	
    //AppUser
	public AppUserResponse mapAppUser(AppUser appuser) {
		AppUserResponse appUserResponse = new AppUserResponse();
		
		appUserResponse.setId(appuser.getId());
		appUserResponse.setUsername(appuser.getUsername());
		appUserResponse.setEmail(appuser.getEmail());
		appUserResponse.setPasswordHash(appuser.getPasswordHash());
		appUserResponse.setFirstName(appuser.getFirstName());
		appUserResponse.setLastName(appuser.getLastName());
		appUserResponse.setMiddleName(appuser.getMiddleName());
		appUserResponse.setNickname(appuser.getNickname());
		appUserResponse.setGender(appuser.getGender());
		appUserResponse.setPhoneNumber(appuser.getPhoneNumber());
		appUserResponse.setAlternatePhoneNumber(appuser.getAlternatePhoneNumber());
		appUserResponse.setAddressLine1(appuser.getAddressLine1());
		appUserResponse.setAddressLine2(appuser.getAddressLine2());
		appUserResponse.setCity(appuser.getCity());
		appUserResponse.setState(appuser.getState());
		appUserResponse.setCountry(appuser.getCountry());
		appUserResponse.setPostalCode(appuser.getPostalCode());
		appUserResponse.setTimeZone(appuser.getTimeZone());
		appUserResponse.setLanguage(appuser.getLanguage());
		appUserResponse.setProfilePictureUrl(appuser.getProfilePictureUrl());
		appUserResponse.setIsActive(appuser.getIsActive());
		appUserResponse.setEmailVerified(appuser.getEmailVerified());
		appUserResponse.setEmailVerificationToken(appuser.getEmailVerificationToken());
		appUserResponse.setPhoneNumberVerified(appuser.getPhoneNumberVerified());
		appUserResponse.setPhoneNumberVerificationToken(appuser.getPhoneNumberVerificationToken());
		if(appuser.getFailedLoginAttempts()!=null)
			appUserResponse.setFailedLoginAttempts(appuser.getFailedLoginAttempts());
		appUserResponse.setAccountLocked(appuser.getAccountLocked());
		appUserResponse.setAccountLockReason(appuser.getAccountLockReason());
		
		appUserResponse.setTwoFactorEnabled(appuser.getTwoFactorEnabled());
		appUserResponse.setTwoFactorSecret(appuser.getTwoFactorSecret());
		appUserResponse.setTwoFactorRecoveryCodes(appuser.getTwoFactorRecoveryCodes());
		
		appUserResponse.setCustomAttribute1(appuser.getCustomAttribute1());
		appUserResponse.setCustomAttribute2(appuser.getCustomAttribute2());
		appUserResponse.setCustomAttribute3(appuser.getCustomAttribute3());
		appUserResponse.setCustomAttribute4(appuser.getCustomAttribute4());
		appUserResponse.setCustomAttribute5(appuser.getCustomAttribute5());
		appUserResponse.setCustomAttribute6(appuser.getCustomAttribute6());
		appUserResponse.setCustomAttribute7(appuser.getCustomAttribute7());
		appUserResponse.setCustomAttribute8(appuser.getCustomAttribute8());
		appUserResponse.setCustomAttribute9(appuser.getCustomAttribute9());
		appUserResponse.setCustomAttribute10(appuser.getCustomAttribute10());
		
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
        XMLGregorianCalendar xmlGregorianCalendar;
		try {
			gregorianCalendar.setTime(appuser.getCreatedAt());
			
			xmlGregorianCalendar = DatatypeFactory
			        .newInstance()
			        .newXMLGregorianCalendar(gregorianCalendar);
			
			appUserResponse.setCreatedAt(xmlGregorianCalendar);
			
			
			gregorianCalendar.setTime(appuser.getUpdatedAt());
			xmlGregorianCalendar = DatatypeFactory
			        .newInstance()
			        .newXMLGregorianCalendar(gregorianCalendar);
			appUserResponse.setUpdatedAt(xmlGregorianCalendar);
			
			
			if(appuser.getDateOfBirth()!=null) {
				gregorianCalendar.setTime(appuser.getDateOfBirth());
				xmlGregorianCalendar = DatatypeFactory
				        .newInstance()
				        .newXMLGregorianCalendar(gregorianCalendar);
				appUserResponse.setDateOfBirth(xmlGregorianCalendar);
			}
			
			if(appuser.getEmailVerificationTokenExpiry()!=null) {
				gregorianCalendar.setTime(appuser.getEmailVerificationTokenExpiry());
				xmlGregorianCalendar = DatatypeFactory
				        .newInstance()
				        .newXMLGregorianCalendar(gregorianCalendar);
				appUserResponse.setEmailVerificationTokenExpiry(xmlGregorianCalendar);
			}
			
			
			if(appuser.getPhoneNumberVerificationTokenExpiry()!=null) {
				gregorianCalendar.setTime(appuser.getPhoneNumberVerificationTokenExpiry());
				xmlGregorianCalendar = DatatypeFactory
				        .newInstance()
				        .newXMLGregorianCalendar(gregorianCalendar);
				appUserResponse.setPhoneNumberVerificationTokenExpiry(xmlGregorianCalendar);
			}
			
			if(appuser.getLastLogin()!=null) {
				gregorianCalendar.setTime(appuser.getLastLogin());
				xmlGregorianCalendar = DatatypeFactory
				        .newInstance()
				        .newXMLGregorianCalendar(gregorianCalendar);
				appUserResponse.setLastLogin(xmlGregorianCalendar);
			}
			
			if(appuser.getAccountLockDate()!=null) {
				gregorianCalendar.setTime(appuser.getAccountLockDate());
				xmlGregorianCalendar = DatatypeFactory
				        .newInstance()
				        .newXMLGregorianCalendar(gregorianCalendar);
				appUserResponse.setAccountLockDate(xmlGregorianCalendar);
			}
			
			
			
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		return appUserResponse;
	}
	
	public AppUser mapAppUserReq(AppUserPostRequest appUserPostRequest) {
		AppUser appUser = new AppUser();
		
		appUser.setUsername(appUserPostRequest.getUsername());
		appUser.setEmail(appUserPostRequest.getEmail());
		appUser.setPasswordHash(appUserPostRequest.getPasswordHash());
		appUser.setFirstName(appUserPostRequest.getFirstName());
		appUser.setLastName(appUserPostRequest.getLastName());
		appUser.setMiddleName(appUserPostRequest.getMiddleName());
		appUser.setNickname(appUserPostRequest.getNickname());
		appUser.setGender(appUserPostRequest.getGender());
		appUser.setPhoneNumber(appUserPostRequest.getPhoneNumber());
		appUser.setAlternatePhoneNumber(appUserPostRequest.getAlternatePhoneNumber());
		appUser.setAddressLine1(appUserPostRequest.getAddressLine1());
		appUser.setAddressLine2(appUserPostRequest.getAddressLine2());
		appUser.setCity(appUserPostRequest.getCity());
		appUser.setState(appUserPostRequest.getState());
		appUser.setCountry(appUserPostRequest.getCountry());
		appUser.setPostalCode(appUserPostRequest.getPostalCode());
		appUser.setTimeZone(appUserPostRequest.getTimeZone());
		appUser.setLanguage(appUserPostRequest.getLanguage());
		appUser.setProfilePictureUrl(appUserPostRequest.getProfilePictureUrl());
		appUser.setIsActive(appUserPostRequest.isIsActive());
		appUser.setEmailVerified(appUserPostRequest.isEmailVerified());
		appUser.setEmailVerificationToken(appUserPostRequest.getEmailVerificationToken());
		appUser.setPhoneNumberVerified(appUserPostRequest.isPhoneNumberVerified());
		appUser.setPhoneNumberVerificationToken(appUserPostRequest.getPhoneNumberVerificationToken());
		if(appUser.getFailedLoginAttempts()!=null)
			appUser.setFailedLoginAttempts(appUserPostRequest.getFailedLoginAttempts());
		appUser.setAccountLocked(appUserPostRequest.isAccountLocked());
		appUser.setAccountLockReason(appUserPostRequest.getAccountLockReason());
		
		appUser.setTwoFactorEnabled(appUserPostRequest.isTwoFactorEnabled());
		appUser.setTwoFactorSecret(appUserPostRequest.getTwoFactorSecret());
		appUser.setTwoFactorRecoveryCodes(appUserPostRequest.getTwoFactorRecoveryCodes());
		
		appUser.setCustomAttribute1(appUserPostRequest.getCustomAttribute1());
		appUser.setCustomAttribute2(appUserPostRequest.getCustomAttribute2());
		appUser.setCustomAttribute3(appUserPostRequest.getCustomAttribute3());
		appUser.setCustomAttribute4(appUserPostRequest.getCustomAttribute4());
		appUser.setCustomAttribute5(appUserPostRequest.getCustomAttribute5());
		appUser.setCustomAttribute6(appUserPostRequest.getCustomAttribute6());
		appUser.setCustomAttribute7(appUserPostRequest.getCustomAttribute7());
		appUser.setCustomAttribute8(appUserPostRequest.getCustomAttribute8());
		appUser.setCustomAttribute9(appUserPostRequest.getCustomAttribute9());
		appUser.setCustomAttribute10(appUserPostRequest.getCustomAttribute10());
		
		
		appUser.setCreatedAt(new Date());
		appUser.setUpdatedAt(new Date()); 
		
		try
		{
			if(appUserPostRequest.getDateOfBirth()!=null) {
				appUser.setDateOfBirth(new Date (appUserPostRequest.getDateOfBirth().toString()));
			}
			
			if(appUserPostRequest.getEmailVerificationTokenExpiry()!=null) {
				appUser.setEmailVerificationTokenExpiry(new Date(appUserPostRequest.getEmailVerificationTokenExpiry().toString()));
			}
			
			if(appUserPostRequest.getPhoneNumberVerificationTokenExpiry()!=null) {
				appUser.setPhoneNumberVerificationTokenExpiry(new Date(appUserPostRequest.getPhoneNumberVerificationTokenExpiry().toString()));
			}
			
			if(appUserPostRequest.getLastLogin()!=null) {
				appUser.setLastLogin(new Date(appUserPostRequest.getLastLogin().toString()));
			}
			
			if(appUserPostRequest.getAccountLockDate()!=null) {
				appUser.setAccountLockDate(new Date(appUserPostRequest.getAccountLockDate().toString()));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return appUser;
	}
	
	public AppUser mapAppUserReqWithId(AppUserPutRequest appUserPutRequest,AppUser appUserDb) {
		AppUser appUser = new AppUser();
		
		appUser.setId(appUserPutRequest.getAppUser().getId());
		appUser.setUsername(appUserPutRequest.getAppUser().getUsername());
		appUser.setEmail(appUserPutRequest.getAppUser().getEmail());
		appUser.setPasswordHash(appUserPutRequest.getAppUser().getPasswordHash());
		appUser.setFirstName(appUserPutRequest.getAppUser().getFirstName());
		appUser.setLastName(appUserPutRequest.getAppUser().getLastName());
		appUser.setMiddleName(appUserPutRequest.getAppUser().getMiddleName());
		appUser.setNickname(appUserPutRequest.getAppUser().getNickname());
		appUser.setGender(appUserPutRequest.getAppUser().getGender());
		appUser.setPhoneNumber(appUserPutRequest.getAppUser().getPhoneNumber());
		appUser.setAlternatePhoneNumber(appUserPutRequest.getAppUser().getAlternatePhoneNumber());
		appUser.setAddressLine1(appUserPutRequest.getAppUser().getAddressLine1());
		appUser.setAddressLine2(appUserPutRequest.getAppUser().getAddressLine2());
		appUser.setCity(appUserPutRequest.getAppUser().getCity());
		appUser.setState(appUserPutRequest.getAppUser().getState());
		appUser.setCountry(appUserPutRequest.getAppUser().getCountry());
		appUser.setPostalCode(appUserPutRequest.getAppUser().getPostalCode());
		appUser.setTimeZone(appUserPutRequest.getAppUser().getTimeZone());
		appUser.setLanguage(appUserPutRequest.getAppUser().getLanguage());
		appUser.setProfilePictureUrl(appUserPutRequest.getAppUser().getProfilePictureUrl());
		appUser.setIsActive(appUserPutRequest.getAppUser().isIsActive());
		appUser.setEmailVerified(appUserPutRequest.getAppUser().isEmailVerified());
		appUser.setEmailVerificationToken(appUserPutRequest.getAppUser().getEmailVerificationToken());
		appUser.setPhoneNumberVerified(appUserPutRequest.getAppUser().isPhoneNumberVerified());
		appUser.setPhoneNumberVerificationToken(appUserPutRequest.getAppUser().getPhoneNumberVerificationToken());
		if(appUser.getFailedLoginAttempts()!=null)
			appUser.setFailedLoginAttempts(appUserPutRequest.getAppUser().getFailedLoginAttempts());
		appUser.setAccountLocked(appUserPutRequest.getAppUser().isAccountLocked());
		appUser.setAccountLockReason(appUserPutRequest.getAppUser().getAccountLockReason());
		
		appUser.setTwoFactorEnabled(appUserPutRequest.getAppUser().isTwoFactorEnabled());
		appUser.setTwoFactorSecret(appUserPutRequest.getAppUser().getTwoFactorSecret());
		appUser.setTwoFactorRecoveryCodes(appUserPutRequest.getAppUser().getTwoFactorRecoveryCodes());
		
		appUser.setCustomAttribute1(appUserPutRequest.getAppUser().getCustomAttribute1());
		appUser.setCustomAttribute2(appUserPutRequest.getAppUser().getCustomAttribute2());
		appUser.setCustomAttribute3(appUserPutRequest.getAppUser().getCustomAttribute3());
		appUser.setCustomAttribute4(appUserPutRequest.getAppUser().getCustomAttribute4());
		appUser.setCustomAttribute5(appUserPutRequest.getAppUser().getCustomAttribute5());
		appUser.setCustomAttribute6(appUserPutRequest.getAppUser().getCustomAttribute6());
		appUser.setCustomAttribute7(appUserPutRequest.getAppUser().getCustomAttribute7());
		appUser.setCustomAttribute8(appUserPutRequest.getAppUser().getCustomAttribute8());
		appUser.setCustomAttribute9(appUserPutRequest.getAppUser().getCustomAttribute9());
		appUser.setCustomAttribute10(appUserPutRequest.getAppUser().getCustomAttribute10());
		
		
		appUser.setCreatedAt(appUserDb.getCreatedAt());
		appUser.setUpdatedAt(new Date()); 
		
		try
		{
			if(appUserPutRequest.getAppUser().getDateOfBirth()!=null) {
				appUser.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(appUserPutRequest.getAppUser().getDateOfBirth().toString()));
			}
			
			if(appUserPutRequest.getAppUser().getEmailVerificationTokenExpiry()!=null) {
				appUser.setEmailVerificationTokenExpiry(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(appUserPutRequest.getAppUser().getEmailVerificationTokenExpiry().toString()));
			}
			
			if(appUserPutRequest.getAppUser().getPhoneNumberVerificationTokenExpiry()!=null) {
				appUser.setPhoneNumberVerificationTokenExpiry(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(appUserPutRequest.getAppUser().getPhoneNumberVerificationTokenExpiry().toString()));
			}
			
			if(appUserPutRequest.getAppUser().getLastLogin()!=null) {
				appUser.setLastLogin(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(appUserPutRequest.getAppUser().getLastLogin().toString()));
			}
			
			if(appUserPutRequest.getAppUser().getAccountLockDate()!=null) {
				appUser.setAccountLockDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(appUserPutRequest.getAppUser().getAccountLockDate().toString()));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return appUser;
	}
	
	//AppUserGroup
	public AppUserGroupResponse mapAppUserGroup(AppUserGroup appUserGroup) {
		AppUserGroupResponse appUserGroupResponse = new AppUserGroupResponse();
		
		appUserGroupResponse.setId(appUserGroup.getId());
		appUserGroupResponse.setUserId(appUserGroup.getUserId());
		appUserGroupResponse.setGroupId(appUserGroup.getGroupId());
		
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
        XMLGregorianCalendar xmlGregorianCalendar;
		try {
			gregorianCalendar.setTime(appUserGroup.getCreatedAt());
			
			xmlGregorianCalendar = DatatypeFactory
			        .newInstance()
			        .newXMLGregorianCalendar(gregorianCalendar);
			
			appUserGroupResponse.setCreatedAt(xmlGregorianCalendar);
			
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		return appUserGroupResponse;
	}
	
	public AppUserGroup mapAppUserGroupReq(AppUserGroupPostRequest appUserGroupPostRequest) {
		AppUserGroup appUserGroup = new AppUserGroup();
		
		appUserGroup.setUserId(appUserGroupPostRequest.getUserId());
		appUserGroup.setGroupId(appUserGroupPostRequest.getGroupId());
		appUserGroup.setCreatedAt(new Date());
		
		return appUserGroup;
	}
	
	public AppUserGroup mapAppUserGroupReqWithId(AppUserGroupPutRequest appUserGroupPutRequest,AppUserGroup appUserGroupDb) {
		AppUserGroup appUserGroup = new AppUserGroup();
		
		appUserGroup.setId(appUserGroupPutRequest.getAppUserGroup().getId());
		appUserGroup.setUserId(appUserGroupPutRequest.getAppUserGroup().getUserId());
		appUserGroup.setGroupId(appUserGroupPutRequest.getAppUserGroup().getGroupId());
		appUserGroup.setCreatedAt(appUserGroupDb.getCreatedAt());
		
		return appUserGroup;
	}
	
	//AppUserRole
		public AppUserRoleResponse mapAppUserRole(AppUserRole appUserRole) {
			AppUserRoleResponse appUserRoleResponse = new AppUserRoleResponse();
			
			appUserRoleResponse.setId(appUserRole.getId());
			appUserRoleResponse.setUserId(appUserRole.getUserId());
			appUserRoleResponse.setRoleId(appUserRole.getRoleId());
			
			
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
	        XMLGregorianCalendar xmlGregorianCalendar;
			try {
				gregorianCalendar.setTime(appUserRole.getCreatedAt());
				
				xmlGregorianCalendar = DatatypeFactory
				        .newInstance()
				        .newXMLGregorianCalendar(gregorianCalendar);
				
				appUserRoleResponse.setCreatedAt(xmlGregorianCalendar);
				
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
			
			return appUserRoleResponse;
		}
		
		public AppUserRole mapAppUserRoleReq(AppUserRolePostRequest appUserRolePostRequest) {
			AppUserRole appUserRole = new AppUserRole();
			
			appUserRole.setUserId(appUserRolePostRequest.getUserId());
			appUserRole.setRoleId(appUserRolePostRequest.getRoleId());
			appUserRole.setCreatedAt(new Date());
			
			return appUserRole;
		}
		
		public AppUserRole mapAppUserRoleReqWithId(AppUserRolePutRequest appUserRolePutRequest,AppUserRole appUserRoleDb) {
			AppUserRole appUserRole = new AppUserRole();
			
			appUserRole.setId(appUserRolePutRequest.getAppUserRole().getId());
			appUserRole.setUserId(appUserRolePutRequest.getAppUserRole().getUserId());
			appUserRole.setRoleId(appUserRolePutRequest.getAppUserRole().getRoleId());
			appUserRole.setCreatedAt(appUserRoleDb.getCreatedAt());
			
			return appUserRole;
		}
	
	
}
