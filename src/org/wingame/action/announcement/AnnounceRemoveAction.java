package org.wingame.action.announcement;

import org.wingame.service.AnnouncementService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AnnounceRemoveAction extends ActionSupport {
	private AnnouncementService announceService;
	
	public AnnouncementService getAnnounceService() {
		return announceService;
	}
	
	public void setAnnounceService(AnnouncementService announceService) {
		this.announceService = announceService;
	}
	
	@Override
	public String execute() throws Exception {
		Integer id = (Integer) ActionContext.getContext().getSession().get("id");
		if(id == null){
			return ERROR;
		}
		else{
			announceService.removeAnnouncement(id);
			return SUCCESS;
		}
	}
}
