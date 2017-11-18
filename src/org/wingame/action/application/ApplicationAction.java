package org.wingame.action.application;

import org.wingame.service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ApplicationAction extends ActionSupport {
	private MeetingService meetingService;
	private int id;

	public int getId() {
		return id;
	}

	@Override
	public String execute() throws Exception {
		id = (Integer) ActionContext.getContext().getSession().get("id");
		String username = (String) ActionContext.getContext().getSession().get("username");
		meetingService.applyMeeting(id, username);
		return SUCCESS;
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
}
