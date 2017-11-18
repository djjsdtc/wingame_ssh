package org.wingame.action.meeting;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.wingame.dao.TMeeting;
import org.wingame.service.MeetingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MeetingAction extends ActionSupport{
	private String title, address, fee;
	private double fee_num;
	private int id;
	
	public int getId() {
		return id;
	}

	private Date date, time, deadline;
	
	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	private MeetingService meetingService;
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	public MeetingService getMeetingService() {
		return meetingService;
	}
	
	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String execute() throws Exception {
		Calendar date_cal = Calendar.getInstance();
		date_cal.setTime(date);
		Calendar datetime_cal = Calendar.getInstance();
		datetime_cal.setTime(time);
		datetime_cal.set(date_cal.get(Calendar.YEAR), date_cal.get(Calendar.MONTH), date_cal.get(Calendar.DATE));
		Timestamp datetime = new Timestamp(datetime_cal.getTimeInMillis());
		Timestamp deadline = new Timestamp(this.deadline.getTime());
		TMeeting meeting = new TMeeting(title,address,datetime,fee_num,deadline);
		if(id != -1){
			meeting.setMId(id);
		}
		id = meetingService.addOrChangeMeeting(meeting);
		return SUCCESS;
	}

	@Override
	public void validate() {
		clearFieldErrors();
		Integer ID = (Integer) ActionContext.getContext().getSession().get("id");
		id = (ID == null) ? -1 : ID;
		System.out.println(id);
		if(fee == null || fee.equals("")){
			addFieldError("fee", "请输入与会费用。");
		}
		else{
			try{
				fee_num = Double.parseDouble(fee);
			}catch(NumberFormatException e){
				addFieldError("fee","输入的费用不正确，请重新输入！");
			}
		}
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
}
