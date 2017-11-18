package org.wingame.action.announcement;

import org.wingame.dao.TAnnounce;
import org.wingame.dao.TMeeting;
import org.wingame.service.AnnouncementService;
import org.wingame.service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AnnounceAction extends ActionSupport{
	private int id, mid;
	private String title, context;
	private MeetingService meetingService;
	private AnnouncementService announceService;

	public int getId() {
		return id;
	}
	
	public int getMid() {
		return mid;
	}
	
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContext() {
		return context;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	public MeetingService getMeetingService() {
		return meetingService;
	}
	
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	
	public AnnouncementService getAnnounceService() {
		return announceService;
	}
	
	public void setAnnounceService(AnnouncementService announceService) {
		this.announceService = announceService;
	}

	@Override
	public String execute() throws Exception {
		TMeeting meeting = meetingService.getMeeting(mid);
		TAnnounce announcement = new TAnnounce(meeting,title,context);
		Integer ID = (Integer) ActionContext.getContext().getSession().get("id");
		id = (ID == null) ? -1 : ID;
		if(id != -1){
			announcement.setAnnId(id);
		}
		id = announceService.addOrChangeAnnouncement(announcement);
		return SUCCESS;
	}
	
}
