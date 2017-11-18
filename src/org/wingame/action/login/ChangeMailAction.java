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
			addFieldError("password", "����д���룡");
		}
		else if(!userService.loginVerify(username,getMD5(password))){
			addFieldError("password", "���벻��ȷ��");
		}
		
		if(originmail == null || originmail.trim().equals("")){
			addFieldError("originmail", "����дԭ���䣡");
		}
		else if(!userService.emailVerify(username, originmail)){
			addFieldError("originmail", "ԭ���䲻��ȷ��");
		}
		
		if(newmail == null || newmail.trim().equals("")){
			addFieldError("newmail", "����д�����䣡");
		}
		else if(!newmail.matches("^[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)*@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$")){
			addFieldError("newmail", "��������ȷ��E-Mail��ַ��");
		}
	}

}
