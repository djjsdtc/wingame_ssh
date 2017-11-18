package org.wingame.dao;

import java.util.Set;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
public class TUser extends AbstractTUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String username, String password, String email, String role,
			String realname, String company) {
		super(username, password, email, role, realname, company);
	}

	/** full constructor */
	public TUser(String username, String password, String email, String role,
			String realname, String company, Set TMeetingStatuses,
			Set TDocuments) {
		super(username, password, email, role, realname, company,
				TMeetingStatuses, TDocuments);
	}

}
