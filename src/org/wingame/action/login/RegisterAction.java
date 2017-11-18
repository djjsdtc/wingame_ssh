package org.wingame.action.login;

import static org.wingame.CommonUtils.*;

import org.wingame.dao.TUser;
import org.wingame.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends RegChangeActionBase {
	private String name;
	private String pswd1;
	private String pswd2;
	private String email;
	private String realname;
	private String company;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPswd1() {
		return pswd1;
	}
	
	public void setPswd1(String pswd1) {
		this.pswd1 = pswd1;
	}
	
	public String getPswd2() {
		return pswd2;
	}
	
	public void setPswd2(String pswd2) {
		this.pswd2 = pswd2;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void validate() {
		clearFieldErrors();
		if(name == null || name.trim().equals("")){
			addFieldError("name", "�û�������Ϊ�գ�");
		}
		else if(userService.userExists(name)){
			addFieldError("name","�û����Ѵ��ڣ��������");
		}
		
		if(pswd1 == null || pswd1.equals("")){
			addFieldError("pswd1", "���벻��Ϊ�գ�");
		}
		else if(pswd1.length() < 6){
			addFieldError("pswd1", "���볤������Ϊ6��");
		}
		
		if(pswd2 == null || pswd2.equals("")){
			addFieldError("pswd2", "���ڴ��ظ��������룡");
		}
		else if(!pswd2.equals(pswd1)){
			addFieldError("pswd2", "ȷ�����������벻һ�£�");
		}
		
		if(email == null || email.trim().equals("")){
			addFieldError("email", "������E-mail��ַ��");
		}
		else if(!email.matches("^[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)*@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$")){
			addFieldError("email", "��������ȷ��E-Mail��ַ��");
		}
		
		if(realname == null || realname.trim().equals("")){
			addFieldError("realname", "��ʵ��������Ϊ�գ�");
		}
		
		if(company == null || company.trim().equals("")){
			addFieldError("company", "��λ����Ϊ�գ�");
		}
	}

	@Override
	protected TUser getTUser() {
		return new TUser(name,getMD5(pswd1),email,"u",realname,company);
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}
