package org.wingame.action.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.wingame.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import static org.wingame.CommonUtils.*;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private boolean writecookie;
	private UserService userService;
	private String redirect;
	
	public String getRedirect() {
		return redirect;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = getMD5(password);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void validate() {
		clearFieldErrors();
		boolean couldReturn = false;
		if(username == null || username.trim().equals("")){
			addFieldError("username","�û�������Ϊ�գ�");
			couldReturn = true;
		}
		else if(!userService.userExists(username)){
			addFieldError("name", "���û��������ڣ������������ע��һ���û���");
			return;
		}
		
		if(password == null || password.equals("")){
			addFieldError("password","���벻��Ϊ�գ�");
			couldReturn = true;
		}
		
		if(couldReturn) return;
		
		if(!userService.loginVerify(username, password)){
			addFieldError("password","�û��������벻��ȷ�������ԣ�");
		}
	}

	public void setWritecookie(String writecookie) {
		this.writecookie = (writecookie != null);
	}

	@Override
	public String execute() throws Exception {
		ActionContext.getContext().getSession().put("username", username);
		if(writecookie){
			HttpServletResponse response = ServletActionContext.getResponse();
			Cookie nmcookie = new Cookie("j2eeworkname",username);
			nmcookie.setMaxAge(14*24*60*60);
			nmcookie.setPath("/");
			response.addCookie(nmcookie);
			Cookie pwcookie = new Cookie("j2eeworksign",password);
			pwcookie.setMaxAge(14*24*60*60);
			pwcookie.setPath("/");
			response.addCookie(pwcookie);
		}
		redirect = (String) ActionContext.getContext().getSession().get("redirect");
		ActionContext.getContext().getSession().remove("redirect");
		if(redirect != null && !redirect.equals("")) return "redirect";
		else return SUCCESS;
	}
}
