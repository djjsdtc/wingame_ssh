package org.wingame.action.meeting;

import org.wingame.service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeetingRemoveAction extends ActionSupport {
	private MeetingService meetingService;

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	@Override
	public String execute() throws Exception {
		Integer id = (Integer) ActionContext.getContext().getSession().get("id");
		if(id == null){
			return ERROR;
		}
		else{
			meetingService.removeMeeting(id);
			return SUCCESS;
		}
	}
}
