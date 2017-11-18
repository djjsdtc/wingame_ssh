package org.wingame.service;

import java.util.List;

import org.wingame.dao.TMeeting;
import org.wingame.dao.TMeetingDAO;
import org.wingame.dao.TMeetingStatus;
import org.wingame.dao.TMeetingStatusDAO;
import org.wingame.dao.TMeetingStatusId;
import org.wingame.dao.TUser;
import org.wingame.dao.TUserDAO;
import org.wingame.dao.VMeetingDAO;

public class MeetingService {
	private TMeetingStatusDAO tMeetingStatusDAO;
	private TMeetingDAO tMeetingDAO;
	private TUserDAO tUserDAO;

	public TMeetingDAO gettMeetingDAO() {
		return tMeetingDAO;
	}

	public void settMeetingDAO(TMeetingDAO tMeetingDAO) {
		this.tMeetingDAO = tMeetingDAO;
	}

	public TUserDAO gettUserDAO() {
		return tUserDAO;
	}

	public void settUserDAO(TUserDAO tUserDAO) {
		this.tUserDAO = tUserDAO;
	}

	public TMeetingStatusDAO gettMeetingStatusDAO() {
		return tMeetingStatusDAO;
	}

	public void settMeetingStatusDAO(TMeetingStatusDAO tMeetingStatusDAO) {
		this.tMeetingStatusDAO = tMeetingStatusDAO;
	}
	
	public boolean attended(String username, int meetingId){
		TUser user = tUserDAO.findById(username);
		TMeeting meeting = tMeetingDAO.findById(meetingId);
		if(user == null || meeting == null){
			return false;
		}
		else{
			TMeetingStatus status = tMeetingStatusDAO.findById(new TMeetingStatusId(user,meeting));
			return (status != null);
		}
	}
	
	public int addOrChangeMeeting(TMeeting meeting){
		TMeeting newmeeting = tMeetingDAO.merge(meeting);
		return newmeeting.getMId();
	}
	
	public TMeeting getMeeting(int id){
		return tMeetingDAO.findById(id);
	}
	
	public void removeMeeting(int id){
		TMeeting meeting = tMeetingDAO.findById(id);
		tMeetingDAO.delete(meeting);
	}
	
	public void applyMeeting(int mid,String username){
		TMeeting meeting = getMeeting(mid);
		TUser user = tUserDAO.findById(username);
		TMeetingStatusId id = new TMeetingStatusId(user,meeting);
		TMeetingStatus status = new TMeetingStatus(id,"p");
		tMeetingStatusDAO.save(status);
	}
	
	public List<TMeetingStatus> getAttendList(int mid){
		return tMeetingStatusDAO.findByProperty("id.TMeeting.MId", mid);
	}
}
