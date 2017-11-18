package org.wingame.action.application;

import org.wingame.dao.TDocument;
import org.wingame.dao.TMeeting;
import org.wingame.service.FileService;
import org.wingame.service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ApplyHomeAction extends ActionSupport {
	private int id;
	private MeetingService meetingService;
	private FileService fileService;
	private TMeeting meeting;
	
	public TMeeting getMeeting() {
		return meeting;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		meeting = meetingService.getMeeting(id);
		if(meeting == null) return ERROR;
		ActionContext.getContext().getSession().put("id", id);
		long datetime = meeting.getMDatetime().getTime();
		if(System.currentTimeMillis() > datetime) return ERROR;
		String username = (String) ActionContext.getContext().getSession().get("username");
		TDocument document = fileService.getDocument(username, id);
		if(document == null || document.getDocStatus().charAt(0) != 'p') return ERROR;
		if(meetingService.attended(username, id)) return "applied";
		else return "toapply";
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
}
