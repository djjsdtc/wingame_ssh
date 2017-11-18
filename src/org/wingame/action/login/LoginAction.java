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
			addFieldError("username","用户名不能为空！");
			couldReturn = true;
		}
		else if(!userService.userExists(username)){
			addFieldError("name", "此用户名不存在，请检查输入或者注册一个用户。");
			return;
		}
		
		if(password == null || password.equals("")){
			addFieldError("password","密码不能为空！");
			couldReturn = true;
		}
		
		if(couldReturn) return;
		
		if(!userService.loginVerify(username, password)){
			addFieldError("password","用户名或密码不正确，请重试！");
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
