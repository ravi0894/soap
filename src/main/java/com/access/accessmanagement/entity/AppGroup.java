package com.access.accessmanagement.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;



@Entity
@Table(name = "ApplicationGroup")
public class AppGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 1024)
    private String description;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private Boolean isSystemGroup;

    private Integer createdBy;
    private Integer updatedBy;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Date updatedAt;
	

    // Custom attributes
    @Lob
    private String customAttribute1;
    @Lob
    private String customAttribute2;
    @Lob
    private String customAttribute3;
    @Lob
    private String customAttribute4;
    @Lob
    private String customAttribute5;
    @Lob
    private String customAttribute6;
    @Lob
    private String customAttribute7;
    @Lob
    private String customAttribute8;
    @Lob
    private String customAttribute9;
    @Lob
    private String customAttribute10;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsSystemGroup() {
		return isSystemGroup;
	}
	public void setIsSystemGroup(Boolean isSystemGroup) {
		this.isSystemGroup = isSystemGroup;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCustomAttribute1() {
		return customAttribute1;
	}
	public void setCustomAttribute1(String customAttribute1) {
		this.customAttribute1 = customAttribute1;
	}
	public String getCustomAttribute2() {
		return customAttribute2;
	}
	public void setCustomAttribute2(String customAttribute2) {
		this.customAttribute2 = customAttribute2;
	}
	public String getCustomAttribute3() {
		return customAttribute3;
	}
	public void setCustomAttribute3(String customAttribute3) {
		this.customAttribute3 = customAttribute3;
	}
	public String getCustomAttribute4() {
		return customAttribute4;
	}
	public void setCustomAttribute4(String customAttribute4) {
		this.customAttribute4 = customAttribute4;
	}
	public String getCustomAttribute5() {
		return customAttribute5;
	}
	public void setCustomAttribute5(String customAttribute5) {
		this.customAttribute5 = customAttribute5;
	}
	public String getCustomAttribute6() {
		return customAttribute6;
	}
	public void setCustomAttribute6(String customAttribute6) {
		this.customAttribute6 = customAttribute6;
	}
	public String getCustomAttribute7() {
		return customAttribute7;
	}
	public void setCustomAttribute7(String customAttribute7) {
		this.customAttribute7 = customAttribute7;
	}
	public String getCustomAttribute8() {
		return customAttribute8;
	}
	public void setCustomAttribute8(String customAttribute8) {
		this.customAttribute8 = customAttribute8;
	}
	public String getCustomAttribute9() {
		return customAttribute9;
	}
	public void setCustomAttribute9(String customAttribute9) {
		this.customAttribute9 = customAttribute9;
	}
	public String getCustomAttribute10() {
		return customAttribute10;
	}
	public void setCustomAttribute10(String customAttribute10) {
		this.customAttribute10 = customAttribute10;
	}
	public AppGroup(Integer id, String name, String description, Boolean isActive, Boolean isSystemGroup,
			Integer createdBy, Integer updatedBy, Date createdAt, Date updatedAt, Set<AppUser> users,
			String customAttribute1, String customAttribute2, String customAttribute3, String customAttribute4,
			String customAttribute5, String customAttribute6, String customAttribute7, String customAttribute8,
			String customAttribute9, String customAttribute10) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
		this.isSystemGroup = isSystemGroup;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.customAttribute1 = customAttribute1;
		this.customAttribute2 = customAttribute2;
		this.customAttribute3 = customAttribute3;
		this.customAttribute4 = customAttribute4;
		this.customAttribute5 = customAttribute5;
		this.customAttribute6 = customAttribute6;
		this.customAttribute7 = customAttribute7;
		this.customAttribute8 = customAttribute8;
		this.customAttribute9 = customAttribute9;
		this.customAttribute10 = customAttribute10;
	}
    
    public AppGroup() {
    	
    }
}
