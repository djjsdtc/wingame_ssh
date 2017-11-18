package org.wingame.action.usermgmt;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.wingame.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserRemoveAction extends ActionSupport {
	private String username;
	private UserService userService;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		userService.removeUser(username);
		return SUCCESS;
	}
}
