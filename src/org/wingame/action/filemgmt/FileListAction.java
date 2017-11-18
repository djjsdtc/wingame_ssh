package org.wingame.action.filemgmt;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.wingame.DocumentDisplayBean;
import org.wingame.HibernateSessionFactory;
import org.wingame.dao.TDocument;
import org.wingame.service.FileMgmtService;

import com.opensymphony.xwork2.ActionSupport;

public class FileListAction extends ActionSupport {
	private FileMgmtService service;
	private List<DocumentDisplayBean> list;
	private int meetingId = -1;
	private int page = 1;
	private int itemsPerPage = 0;
	private int totalPage = 1;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public FileMgmtService getService() {
		return service;
	}
	
	public void setService(FileMgmtService service) {
		this.service = service;
	}
	
	public int getMeetingId() {
		return meetingId;
	}
	
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	
	public List<DocumentDisplayBean> getList() {
		return list;
	}

	@Override
	public String execute() throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TDocument.class);
		if(meetingId != -1){
			criteria.add(Restrictions.eq("id.TMeeting.MId", meetingId));
		}
		if(itemsPerPage != 0){
			totalPage = (int) Math.ceil(criteria.list().size()/(double)itemsPerPage);
			criteria.setFirstResult((page-1)*itemsPerPage);
			criteria.setMaxResults(itemsPerPage);
		}
		List dbList = criteria.list();
		list = service.getDocumentDisplayList(dbList);
		return SUCCESS;
	}
}
