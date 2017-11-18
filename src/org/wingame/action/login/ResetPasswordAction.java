package org.wingame.action.login;

import org.springframework.mail.SimpleMailMessage;
import org.wingame.MailTemplate;
import org.wingame.dao.TUser;
import org.wingame.service.MailService;
import org.wingame.service.UserService;

import static org.wingame.CommonUtils.*;

public class ResetPasswordAction extends RegChangeActionBase {
	private String name;
	private String mail;
	private String newPassword;
	private TUser user;
	private MailService mailService;

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String execute() throws Exception {
		newPassword = getRandomPassword(8);
		String message = MailTemplate.getResetPasswordContext(newPassword);
		SimpleMailMessage msg = mailService.getMail(user.getEmail(), "找回密码", message);
		mailService.sendMail(msg);
		return super.execute();
	}

	@Override
	protected TUser getTUser() {
		user.setPassword(getMD5(newPassword));
		return user;
	}

	@Override
	public void validate() {
		clearFieldErrors();
		user = userService.getUser(name);
		
		if(name == null || name.trim().equals("")){
			addFieldError("name", "请填写用户名！");
		}
		else if(!userService.userExists(name)){
			addFieldError("name", "此用户名不存在，请检查输入或者注册一个用户。");
			return;
		}
		
		if(mail == null || mail.trim().equals("")){
			addFieldError("mail", "请填写邮箱！");
		}
		else if(!userService.emailVerify(name, mail)){
			addFieldError("mail", "邮箱不正确！");
		}
	}
}
