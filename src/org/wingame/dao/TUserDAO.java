package org.wingame.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for TUser
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.wingame.dao.TUser
 * @author MyEclipse Persistence Tools
 */

public class TUserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TUserDAO.class);
	// property constants
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String ROLE = "role";
	public static final String REALNAME = "realname";
	public static final String COMPANY = "company";

	protected void initDao() {
		// do nothing
	}

	public void save(TUser transientInstance) {
		log.debug("saving TUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TUser persistentInstance) {
		log.debug("deleting TUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUser findById(java.lang.String id) {
		log.debug("getting TUser instance with id: " + id);
		try {
			TUser instance = (TUser) getHibernateTemplate().get(
					"org.wingame.dao.TUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TUser instance) {
		log.debug("finding TUser instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	public List findByRealname(Object realname) {
		return findByProperty(REALNAME, realname);
	}

	public List findByCompany(Object company) {
		return findByProperty(COMPANY, company);
	}

	public List findAll() {
		log.debug("finding all TUser instances");
		try {
			String queryString = "from TUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TUser merge(TUser detachedInstance) {
		log.debug("merging TUser instance");
		try {
			TUser result = (TUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUser instance) {
		log.debug("attaching dirty TUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUser instance) {
		log.debug("attaching clean TUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TUserDAO) ctx.getBean("TUserDAO");
	}
}