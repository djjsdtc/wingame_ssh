package org.wingame.action.login;

import org.wingame.dao.TUser;
import static org.wingame.CommonUtils.*;

import com.opensymphony.xwork2.ActionContext;

public class ChangePasswordAction extends RegChangeActionBase {
	private TUser user;
	private String origin;
	private String new1;
	private String new2;
	
	@Override
	protected TUser getTUser() {
		user.setPassword(getMD5(new1));
		return user;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getNew1() {
		return new1;
	}

	public void setNew1(String new1) {
		this.new1 = new1;
	}

	public String getNew2() {
		return new2;
	}

	public void setNew2(String new2) {
		this.new2 = new2;
	}

	@Override
	public void validate() {
		clearFieldErrors();
		String username = (String) ActionContext.getContext().getSession().get("username");
		user = userService.getUser(username);
		
		if(origin == null || origin.equals("")){
			addFieldError("origin", "����д���룡");
		}
		else if(!userService.loginVerify(username, getMD5(origin))){
			addFieldError("origin", "���벻��ȷ��");
		}
		
		if(new1 == null || new1.equals("")){
			addFieldError("new1", "�����벻��Ϊ�գ�");
		}
		else if(new1.length() < 6){
			addFieldError("new1", "�����볤������Ϊ6��");
		}
		
		if(new2 == null || new2.equals("")){
			addFieldError("new2", "���ڴ��ظ��������룡");
		}
		else if(!new2.equals(new1)){
			addFieldError("new2", "ȷ�����������벻һ�£�");
		}
	}

}
