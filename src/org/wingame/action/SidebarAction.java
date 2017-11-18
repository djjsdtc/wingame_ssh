package org.wingame.action;

import org.wingame.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SidebarAction extends ActionSupport {
	private UserService userService;
	private String redirect = "";

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		//ActionContext.getContext().getSession().put("username","admin");
		String username = (String) ActionContext.getContext().getSession().get("username");
		return userService.getRole(username);
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
}
