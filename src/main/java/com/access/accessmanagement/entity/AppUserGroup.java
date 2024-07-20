package com.access.accessmanagement.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ApplicationUserGroup")
public class AppUserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String userId;
    
    @Column(nullable = false)
    private String groupId;

    @Column(nullable = false)
    private Date createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public AppUserGroup(Integer id, String userId, String groupId, Date createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.groupId = groupId;
		this.createdAt = createdAt;
	}

	public AppUserGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

       
}

