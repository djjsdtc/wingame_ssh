package org.wingame.action.meeting;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.wingame.ExcelTableUtil;
import org.wingame.dao.TMeetingStatus;
import org.wingame.service.MeetingService;

import com.opensymphony.xwork2.ActionSupport;

public class ExcelTableAction extends ActionSupport {
	private MeetingService service;
	private int mid = -1;
	private InputStream target;

	public InputStream getTarget() {
		return target;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public MeetingService getService() {
		return service;
	}

	public void setService(MeetingService service) {
		this.service = service;
	}

	@Override
	public String execute() throws Exception {
		List<TMeetingStatus> list = service.getAttendList(mid);
		String meetingName = service.getMeeting(mid).getMTitle();
		if(list == null) return ERROR;
		ExcelTableUtil util = new ExcelTableUtil(list,meetingName);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		util.createTable(os);
		target = util.getInputStream(os);
		return SUCCESS;
	}
}
