package org.wingame.action.filemgmt;

import org.springframework.mail.SimpleMailMessage;
import org.wingame.MailTemplate;
import org.wingame.service.FileMgmtService;
import org.wingame.service.MailService;

import com.opensymphony.xwork2.ActionSupport;

public class FileVerifyAction extends ActionSupport {
	private FileMgmtService service;
	private MailService mailService;
	private int mid;
	private String username;
	private String status;
	private int page;
	
	public FileMgmtService getService() {
		return service;
	}
	
	public void setService(FileMgmtService service) {
		this.service = service;
	}
	
	public MailService getMailService() {
		return mailService;
	}
	
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	
	public int getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = Integer.parseInt(mid);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String execute() throws Exception {
		service.verifyFile(mid, username, status);
		String meeting = service.getMeeting(mid).getMTitle();
		String to = service.getEmail(username);
		String context = null;
		if(status.charAt(0)=='p'){
			context = MailTemplate.getDocPassContext(username, meeting, mid);
		}
		else{
			context = MailTemplate.getDocFailContext(username, meeting);
		}
		SimpleMailMessage message = mailService.getMail(to, "ÎÄµµÉóºË½á¹û", context);
		mailService.sendMail(message);
		return SUCCESS;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
