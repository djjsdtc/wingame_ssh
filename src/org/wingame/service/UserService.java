package org.wingame.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.wingame.HibernateSessionFactory;
import org.wingame.dao.TUser;
import org.wingame.dao.TUserDAO;

public class UserService {
	private TUserDAO tUserDAO;

	public TUserDAO gettUserDAO() {
		return tUserDAO;
	}

	public void settUserDAO(TUserDAO tUserDAO) {
		this.tUserDAO = tUserDAO;
	}
	
	public String getRole(String username){
		if(username == null || username.trim().equals("")) return "g";
		else{
			TUser user = getUser(username);
			if(user == null) return "g";
			else return user.getRole();
		}
	}
	
	public boolean loginVerify(String username, String password){
		if(username == null || username.trim().equals("") || password == null || password.equals(""))
			return false;
		else{
			TUser user = getUser(username);
			if(user == null) return false;
			else{
				String correctPass = user.getPassword();
				return password.equals(correctPass);
			}
		}
	}
	
	public void registerOrChange(TUser user){
		tUserDAO.merge(user);
	}
	
	public boolean userExists(String username){
		if(username == null) return true;
		else{
			TUser user = getUser(username);
			return (user != null);
		}
	}
	
	public boolean emailVerify(String username,String email){
		if(username == null || username.trim().equals("") || email == null || email.trim().equals(""))
			return false;
		else{
			TUser user = getUser(username);
			if(user == null) return false;
			else{
				String correctMail = user.getEmail();
				return email.equals(correctMail);
			}
		}
	}
	
	public TUser getUser(String username){
		return tUserDAO.findById(username);
	}
	
	public void removeUser(String username){
		tUserDAO.delete(tUserDAO.findById(username));
	}
}
