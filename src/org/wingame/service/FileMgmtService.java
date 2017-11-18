package org.wingame.service;

import java.util.ArrayList;
import java.util.List;

import org.wingame.DocumentDisplayBean;
import org.wingame.dao.TDocument;
import org.wingame.dao.TDocumentDAO;
import org.wingame.dao.TDocumentId;
import org.wingame.dao.TMeeting;
import org.wingame.dao.TMeetingDAO;
import org.wingame.dao.TMeetingStatus;
import org.wingame.dao.TMeetingStatusDAO;
import org.wingame.dao.TMeetingStatusId;
import org.wingame.dao.TUser;
import org.wingame.dao.TUserDAO;

public class FileMgmtService {
	private TDocumentDAO tDocumentDAO;
	private TUserDAO tUserDAO;
	private TMeetingDAO tMeetingDAO;
	
	public TDocumentDAO gettDocumentDAO() {
		return tDocumentDAO;
	}
	
	public void settDocumentDAO(TDocumentDAO tDocumentDAO) {
		this.tDocumentDAO = tDocumentDAO;
	}
	
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
	
	public List<DocumentDisplayBean> getDocumentDisplayList(List dbDocumentList){
		List<DocumentDisplayBean> list = new ArrayList<DocumentDisplayBean>(dbDocumentList.size());
		for(TDocument document : (List<TDocument>)dbDocumentList){
			DocumentDisplayBean bean = new DocumentDisplayBean();
			bean.setUsername(document.getId().getTUser().getUsername());
			bean.setMid(document.getId().getTMeeting().getMId());
			switch(document.getDocStatus().charAt(0)){
			case 'p':
				bean.setStatus("已通过");
				break;
			case 'f':
				bean.setStatus("未通过");
				break;
			default:
				bean.setStatus("待审核");
				break;
			}
			bean.setFilename(document.getDocFilename());
			list.add(bean);
		}
		return list; 
	}
	
	public TMeeting getMeeting(int meetingId){
		if(meetingId == -1) return null;
		return tMeetingDAO.findById(meetingId);
	}
	
	public void verifyFile(int mid,String username,String status){
		System.out.println(username + mid);
		TMeeting meeting = getMeeting(mid);
		TUser user = tUserDAO.findById(username);
		TDocumentId id = new TDocumentId(user,meeting);
		TDocument document = tDocumentDAO.findById(id);
		document.setDocStatus(status);
		tDocumentDAO.merge(document);
	}
	
	public String getEmail(String username){
		return tUserDAO.findById(username).getEmail();
	}
}
