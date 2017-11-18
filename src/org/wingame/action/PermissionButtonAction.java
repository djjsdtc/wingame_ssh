package org.wingame.action;

import org.wingame.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PermissionButtonAction extends ActionSupport{
	private int id;
	private String type;
	private String actualPerm;
	private String requiredPerm;
	private UserService userService;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getActualPerm() {
		return actualPerm;
	}

	public void setActualPerm(String actualPerm) {
		this.actualPerm = actualPerm;
	}

	public String getRequiredPerm() {
		return requiredPerm;
	}

	public void setRequiredPerm(String requiredPerm) {
		this.requiredPerm = requiredPerm;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		actualPerm = userService.getRole((String) ActionContext.getContext().getSession().get("username"));
		return SUCCESS;
	}
}
