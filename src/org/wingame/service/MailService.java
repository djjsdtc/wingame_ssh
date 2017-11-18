package org.wingame.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailService {
	private JavaMailSenderImpl mailSender;

	public JavaMailSenderImpl getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}
	
	public SimpleMailMessage getMail(String to, String subject, String text){
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("358930328@qq.com");
		msg.setTo(to);
		msg.setSubject("【Windows 小游戏研究学会】" + subject);
		msg.setText(text);
		return msg;
	}
	
	public void sendMail(SimpleMailMessage msg){
		mailSender.getJavaMailProperties().put("mail.smtp.auth", "true");
		mailSender.send(msg);
	}
}
