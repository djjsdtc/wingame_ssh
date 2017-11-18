package org.wingame.action.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	private String redirect;

	@Override
	public String execute() throws Exception {
		ActionContext.getContext().getSession().remove("username");
		HttpServletResponse response = ServletActionContext.getResponse();
		Cookie nmcookie = new Cookie("j2eeworkname",null);
		nmcookie.setMaxAge(0);
		nmcookie.setPath("/");
		response.addCookie(nmcookie);
		Cookie pwcookie = new Cookie("j2eeworksign",null);
		pwcookie.setMaxAge(0);
		pwcookie.setPath("/");
		response.addCookie(pwcookie);
		return SUCCESS;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

}
