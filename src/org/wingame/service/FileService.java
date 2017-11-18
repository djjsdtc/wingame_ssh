package org.wingame.service;

import java.io.File;

import org.wingame.dao.TDocument;
import org.wingame.dao.TDocumentDAO;
import org.wingame.dao.TDocumentId;
import org.wingame.dao.TMeeting;
import org.wingame.dao.TMeetingDAO;
import org.wingame.dao.TUser;
import org.wingame.dao.TUserDAO;

public class FileService {
	private TUserDAO tUserDAO;
	private TMeetingDAO tMeetingDAO;
	private TDocumentDAO tDocumentDAO;
	
	public TUserDAO gettUserDAO() {
		return tUserDAO;
	}
	
	public void settUserDAO(TUserDAO tUserDAO) {
		this.tUserDAO = tUserDAO;
	}
	
	public TMeetingDAO gettMeetingDAO() {
		return tMeetingDAO;
	}
	
	public void settMeetingDAO(TMeetingDAO tMeetingDAO) {
		this.tMeetingDAO = tMeetingDAO;
	}
	
	public TDocumentDAO gettDocumentDAO() {
		return tDocumentDAO;
	}
	
	public void settDocumentDAO(TDocumentDAO tDocumentDAO) {
		this.tDocumentDAO = tDocumentDAO;
	}
	
	public TDocument getDocument(String username, int meetingId){
		if(username == null || meetingId == -1) return null;
		TUser user = tUserDAO.findById(username);
		TMeeting meeting = tMeetingDAO.findById(meetingId);
		if(user == null || meeting == null) return null;
		else return tDocumentDAO.findById(new TDocumentId(user, meeting));
	}
	
	public long getDeadline(int meetingId){
		TMeeting meeting = tMeetingDAO.findById(meetingId);
		if(meeting == null) return 0;
		else return meeting.getMDeadline().getTime();
	}
	
	public long getDatetime(int meetingId){
		TMeeting meeting = tMeetingDAO.findById(meetingId);
		if(meeting == null) return 0;
		else return meeting.getMDatetime().getTime();
	}
	
	public void createFileRecord(String username, int meetingId, String filename){
		if(username == null || meetingId == -1) return;
		TUser user = tUserDAO.findById(username);
		TMeeting meeting = tMeetingDAO.findById(meetingId);
		if(user == null || meeting == null) return;
		TDocumentId documentId = new TDocumentId(user,meeting);
		TDocument document = new TDocument(documentId,filename,"w");
		tDocumentDAO.save(document);
	}
	
	public void removeFile(String username, int meetingId, String path){
		TDocument document = getDocument(username,meetingId);
		if(document != null){
			String fileName = document.getDocFilename();
			File fileToRemove = new File(path + File.separator + fileName);
			fileToRemove.delete();
			tDocumentDAO.delete(document);
		}
	}
}
