package org.wingame.action;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.wingame.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

public class DataListAction extends MessageActionBase {
	private String entityType;
	private int page = 1;
	private int itemsPerPage = 0;
	private int totalPage = 1;
	private String meetingKeyName = null;
	private int meetingId = -1;
	private List list;

	public List getList() {
		return list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public String getMeetingKeyName() {
		return meetingKeyName;
	}

	public void setMeetingKeyName(String meetingKeyName) {
		this.meetingKeyName = meetingKeyName;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

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

	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	@Override
	public String execute() throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(entityType);
		if(meetingKeyName != null && meetingId != -1){
			criteria.add(Restrictions.eq(meetingKeyName, meetingId));
		}
		if(itemsPerPage != 0){
			totalPage = (int) Math.ceil(criteria.list().size()/(double)itemsPerPage);
			criteria.setFirstResult((page-1)*itemsPerPage);
			criteria.setMaxResults(itemsPerPage);
		}
		list = criteria.list();
		return SUCCESS;
	}
	
	
}
