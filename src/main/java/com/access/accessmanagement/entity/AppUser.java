package com.access.accessmanagement.entity;

import java.util.Date;

import access.management.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "AppUser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String firstName;
    private String lastName;
    private String middleName;
    private String nickname;
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phoneNumber;
    private String alternatePhoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String timeZone;
    private String language;

    @Column(length = 512)
    private String profilePictureUrl;

    @Column(nullable = false)
    private Boolean isActive;
    @Column(nullable = false)
    private Boolean emailVerified;
    private String emailVerificationToken;
    private Date emailVerificationTokenExpiry;

    @Column(nullable = false)
    private Boolean phoneNumberVerified;
    private String phoneNumberVerificationToken;
    private Date phoneNumberVerificationTokenExpiry;

    private Date lastLogin;
    private Integer failedLoginAttempts;
    private Boolean accountLocked;
    private String accountLockReason;
    private Date accountLockDate;
    private Boolean twoFactorEnabled;
    private String twoFactorSecret;
    private String twoFactorRecoveryCodes;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public Date getEmailVerificationTokenExpiry() {
		return emailVerificationTokenExpiry;
	}

	public void setEmailVerificationTokenExpiry(Date emailVerificationTokenExpiry) {
		this.emailVerificationTokenExpiry = emailVerificationTokenExpiry;
	}

	public Boolean getPhoneNumberVerified() {
		return phoneNumberVerified;
	}

	public void setPhoneNumberVerified(Boolean phoneNumberVerified) {
		this.phoneNumberVerified = phoneNumberVerified;
	}

	public String getPhoneNumberVerificationToken() {
		return phoneNumberVerificationToken;
	}

	public void setPhoneNumberVerificationToken(String phoneNumberVerificationToken) {
		this.phoneNumberVerificationToken = phoneNumberVerificationToken;
	}

	public Date getPhoneNumberVerificationTokenExpiry() {
		return phoneNumberVerificationTokenExpiry;
	}

	public void setPhoneNumberVerificationTokenExpiry(Date phoneNumberVerificationTokenExpiry) {
		this.phoneNumberVerificationTokenExpiry = phoneNumberVerificationTokenExpiry;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getFailedLoginAttempts() {
		return failedLoginAttempts;
	}

	public void setFailedLoginAttempts(Integer failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	public Boolean getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public String getAccountLockReason() {
		return accountLockReason;
	}

	public void setAccountLockReason(String accountLockReason) {
		this.accountLockReason = accountLockReason;
	}

	public Date getAccountLockDate() {
		return accountLockDate;
	}

	public void setAccountLockDate(Date accountLockDate) {
		this.accountLockDate = accountLockDate;
	}

	public Boolean getTwoFactorEnabled() {
		return twoFactorEnabled;
	}

	public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getTwoFactorSecret() {
		return twoFactorSecret;
	}

	public void setTwoFactorSecret(String twoFactorSecret) {
		this.twoFactorSecret = twoFactorSecret;
	}

	public String getTwoFactorRecoveryCodes() {
		return twoFactorRecoveryCodes;
	}

	public void setTwoFactorRecoveryCodes(String twoFactorRecoveryCodes) {
		this.twoFactorRecoveryCodes = twoFactorRecoveryCodes;
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

	public AppUser(Integer id, String username, String email, String passwordHash, String firstName, String lastName,
			String middleName, String nickname, Date dateOfBirth, Gender gender, String phoneNumber,
			String alternatePhoneNumber, String addressLine1, String addressLine2, String city, String state,
			String country, String postalCode, String timeZone, String language, String profilePictureUrl,
			Boolean isActive, Boolean emailVerified, String emailVerificationToken, Date emailVerificationTokenExpiry,
			Boolean phoneNumberVerified, String phoneNumberVerificationToken, Date phoneNumberVerificationTokenExpiry,
			Date lastLogin, Integer failedLoginAttempts, Boolean accountLocked, String accountLockReason,
			Date accountLockDate, Boolean twoFactorEnabled, String twoFactorSecret, String twoFactorRecoveryCodes,
			Date createdAt, Date updatedAt, String customAttribute1, String customAttribute2, String customAttribute3,
			String customAttribute4, String customAttribute5, String customAttribute6, String customAttribute7,
			String customAttribute8, String customAttribute9, String customAttribute10) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.nickname = nickname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.alternatePhoneNumber = alternatePhoneNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.timeZone = timeZone;
		this.language = language;
		this.profilePictureUrl = profilePictureUrl;
		this.isActive = isActive;
		this.emailVerified = emailVerified;
		this.emailVerificationToken = emailVerificationToken;
		this.emailVerificationTokenExpiry = emailVerificationTokenExpiry;
		this.phoneNumberVerified = phoneNumberVerified;
		this.phoneNumberVerificationToken = phoneNumberVerificationToken;
		this.phoneNumberVerificationTokenExpiry = phoneNumberVerificationTokenExpiry;
		this.lastLogin = lastLogin;
		this.failedLoginAttempts = failedLoginAttempts;
		this.accountLocked = accountLocked;
		this.accountLockReason = accountLockReason;
		this.accountLockDate = accountLockDate;
		this.twoFactorEnabled = twoFactorEnabled;
		this.twoFactorSecret = twoFactorSecret;
		this.twoFactorRecoveryCodes = twoFactorRecoveryCodes;
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
    
    public AppUser() {
    	
    }

}
