package org.wingame.interceptors;

import org.wingame.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PermissionInterceptor extends AbstractInterceptor {
	private String permissionLevel;
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getPermissionLevel() {
		return permissionLevel;
	}
	
	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String username = (String) ActionContext.getContext().getSession().get("username");
		String permission = userService.getRole(username);
		if(permission.equals(permissionLevel)) return invocation.invoke();
		else return "homepage";
	}

}
