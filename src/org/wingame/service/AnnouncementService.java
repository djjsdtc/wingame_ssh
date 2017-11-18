package org.wingame.service;

import org.wingame.dao.TAnnounce;
import org.wingame.dao.TAnnounceDAO;

public class AnnouncementService {
	private TAnnounceDAO tAnnounceDAO;

	public TAnnounceDAO gettAnnounceDAO() {
		return tAnnounceDAO;
	}

	public void settAnnounceDAO(TAnnounceDAO tAnnounceDAO) {
		this.tAnnounceDAO = tAnnounceDAO;
	}
	
	public int addOrChangeAnnouncement(TAnnounce announcement){
		TAnnounce newann = tAnnounceDAO.merge(announcement);
		return newann.getAnnId();
	}
	
	public void removeAnnouncement(int annId){
		TAnnounce announcement = tAnnounceDAO.findById(annId);
		tAnnounceDAO.delete(announcement);
	}
}
