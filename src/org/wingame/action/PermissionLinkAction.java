package org.wingame.action;

import org.wingame.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PermissionLinkAction extends ActionSupport {
	private String actualPerm;
	private String requiredPerm;
	private String href;
	private String text;
	private UserService userService;
	
	public String getActualPerm() {
		return actualPerm;
	}
	
	public String getRequiredPerm() {
		return requiredPerm;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setRequiredPerm(String requiredPerm) {
		this.requiredPerm = requiredPerm;
	}

	public String getHref() {
		return href;
	}
	
	public void setHref(String href) {
		this.href = href;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String execute() throws Exception {
		actualPerm = userService.getRole((String) ActionContext.getContext().getSession().get("username"));
		return SUCCESS;
	}
}
