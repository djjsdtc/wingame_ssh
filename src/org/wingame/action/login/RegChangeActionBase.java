package org.wingame.action.login;

import org.wingame.dao.TUser;
import org.wingame.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public abstract class RegChangeActionBase extends ActionSupport{
	protected UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		TUser user = getTUser();
		userService.registerOrChange(user);
		return SUCCESS;
	}

	protected abstract TUser getTUser();
	
	@Override
	public abstract void validate();
}
