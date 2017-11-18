package org.wingame.dao;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTUser entity provides the base persistence definition of the TUser
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTUser implements java.io.Serializable {

	// Fields

	private String username;
	private String password;
	private String email;
	private String role;
	private String realname;
	private String company;
	private Set TMeetingStatuses = new HashSet(0);
	private Set TDocuments = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTUser() {
	}

	/** minimal constructor */
	public AbstractTUser(String username, String password, String email,
			String role, String realname, String company) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.realname = realname;
		this.company = company;
	}

	/** full constructor */
	public AbstractTUser(String username, String password, String email,
			String role, String realname, String company, Set TMeetingStatuses,
			Set TDocuments) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.realname = realname;
		this.company = company;
		this.TMeetingStatuses = TMeetingStatuses;
		this.TDocuments = TDocuments;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Set getTMeetingStatuses() {
		return this.TMeetingStatuses;
	}

	public void setTMeetingStatuses(Set TMeetingStatuses) {
		this.TMeetingStatuses = TMeetingStatuses;
	}

	public Set getTDocuments() {
		return this.TDocuments;
	}

	public void setTDocuments(Set TDocuments) {
		this.TDocuments = TDocuments;
	}

}