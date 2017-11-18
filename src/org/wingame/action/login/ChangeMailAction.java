package org.wingame.action.login;

import org.wingame.dao.TUser;
import static org.wingame.CommonUtils.*;
import com.opensymphony.xwork2.ActionContext;

public class ChangeMailAction extends RegChangeActionBase {
	private TUser user;
	private String password;
	private String originmail;
	private String newmail;
	
	public String getOriginmail() {
		return originmail;
	}

	public void setOriginmail(String originmail) {
		this.originmail = originmail;
	}

	public String getNewmail() {
		return newmail;
	}

	public void setNewmail(String newmail) {
		this.newmail = newmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected TUser getTUser() {
		user.setEmail(newmail);
		return user;
	}

	@Override
	public void validate() {
		clearFieldErrors();
		String username = (String) ActionContext.getContext().getSession().get("username");
		user = userService.getUser(username);
		
		if(password == null || password.equals("")){
			addFieldError("password", "请填写密码！");
		}
		else if(!userService.loginVerify(username,getMD5(password))){
			addFieldError("password", "密码不正确！");
		}
		
		if(originmail == null || originmail.trim().equals("")){
			addFieldError("originmail", "请填写原邮箱！");
		}
		else if(!userService.emailVerify(username, originmail)){
			addFieldError("originmail", "原邮箱不正确！");
		}
		
		if(newmail == null || newmail.trim().equals("")){
			addFieldError("newmail", "请填写新邮箱！");
		}
		else if(!newmail.matches("^[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)*@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$")){
			addFieldError("newmail", "请输入正确的E-Mail地址！");
		}
	}

}
