package com.askit.entities;

import java.util.Date;

import com.thirdparty.entities.Column;
import com.thirdparty.entities.Entity;

@Entity
public class User {

	@Column(name = "userID")
	private Long userID;
	@Column(name = "passwordHash")
	private String passwordHash;
	@Column(name = "phoneNumberHash")
	private String phoneNumberHash;
	@Column(name = "username")
	private String username;
	@Column(name = "accessionDate")
	private Date accessionDate;
	@Column(name = "profilePictureURI")
	private String profilePictureURI;
	@Column(name = "language")
	private String language;
	@Column(name = "scoreOfGlobal")
	private int scoreOfGlobal;

	public User() {
	}

	public User(final Long userID, final String passwordHash, final String phoneNumberHash, final String username, final Date accessionDate,
			final String profilePictureURI, final String language, final int scoreOfGlobal) {
		this.userID = userID;
		this.passwordHash = passwordHash;
		this.phoneNumberHash = phoneNumberHash;
		this.username = username;
		this.accessionDate = accessionDate;
		this.profilePictureURI = profilePictureURI;
		this.language = language;
		this.scoreOfGlobal = scoreOfGlobal;
	}

	public Long getUserID() {
		return userID;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getPhoneNumberHash() {
		return phoneNumberHash;
	}

	public String getUsername() {
		return username;
	}

	public Date getAccessionDate() {
		return accessionDate;
	}

	public String getProfilePictureURI() {
		return profilePictureURI;
	}

	public String getLanguage() {
		return language;
	}

	public int getScoreOfGlobal() {
		return scoreOfGlobal;
	}

	public void setUserID(final Long userID) {
		this.userID = userID;
	}

	public void setPasswordHash(final String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public void setPhoneNumberHash(final String phoneNumberHash) {
		this.phoneNumberHash = phoneNumberHash;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public void setAccessionDate(final Date accessionDate) {
		this.accessionDate = accessionDate;
	}

	public void setProfilePictureURI(final String profilePictureURI) {
		this.profilePictureURI = profilePictureURI;
	}

	public void setLanguage(final String language) {
		this.language = language;
	}

	public void setScoreOfGlobal(final int scoreOfGlobal) {
		this.scoreOfGlobal = scoreOfGlobal;
	}

}