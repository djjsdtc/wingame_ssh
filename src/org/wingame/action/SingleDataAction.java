package org.wingame.action;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.wingame.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

public class SingleDataAction extends MessageActionBase{
	private String idType;
	private String entityType;
	private Object result;
	private int id = -1;
	
	public List getMeetingList() throws Exception{
		DataListAction dla = new DataListAction();
		dla.setEntityType("org.wingame.dao.VMeeting");
		dla.execute();
		return dla.getList();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdType() {
		return idType;
	}
	
	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	public String getEntityType() {
		return entityType;
	}
	
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	
	public Object getResult() {
		return result;
	}
	
	@Override
	public String execute() throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(entityType);
		criteria.add(Restrictions.eq(idType, id));
		result = criteria.uniqueResult();
		if(result == null) return ERROR;
		else return SUCCESS;
	}
}
