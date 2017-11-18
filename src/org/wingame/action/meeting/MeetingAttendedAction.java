package org.wingame.action.meeting;

import org.wingame.service.MeetingService;
import org.wingame.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeetingAttendedAction extends ActionSupport {
	private String actualPerm;
	private boolean attended;
	private UserService userService;
	private MeetingService meetingService;
	private int meetingId;
	
	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public String getActualPerm() {
		return actualPerm;
	}
	
	public boolean isAttended() {
		return attended;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		String username = (String) ActionContext.getContext().getSession().get("username");
		actualPerm = userService.getRole(username);
		attended = meetingService.attended(username, meetingId);
		return SUCCESS;
	}
}
