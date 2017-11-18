package org.wingame.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.wingame.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CookieInterceptor extends AbstractInterceptor {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		searchCookie();
		return invocation.invoke();
	}

	private void searchCookie(){
		String username = (String) ActionContext.getContext().getSession().get("username");
		if(username != null) return;
		else{
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			String password = null;
			if(cookies != null){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("j2eeworkname")){
						username = cookie.getValue();
					}
					if(cookie.getName().equals("j2eeworksign")){
						password = cookie.getValue();
					}
				}
			}
			if(username != null && password != null && userService.loginVerify(username, password)){
				ActionContext.getContext().getSession().put("username", username);
				return;
			}
			else{
				HttpServletResponse response = ServletActionContext.getResponse();
				Cookie nmcookie = new Cookie("j2eeworkname",null);
				nmcookie.setMaxAge(0);
				nmcookie.setPath("/");
				response.addCookie(nmcookie);
				Cookie pwcookie = new Cookie("j2eeworksign",null);
				pwcookie.setMaxAge(0);
				pwcookie.setPath("/");
				response.addCookie(pwcookie);
				return;
			}
		}
	}
}
