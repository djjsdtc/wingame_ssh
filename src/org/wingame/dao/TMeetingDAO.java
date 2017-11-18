package org.wingame.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TMeeting entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.wingame.dao.TMeeting
 * @author MyEclipse Persistence Tools
 */

public class TMeetingDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TMeetingDAO.class);
	// property constants
	public static final String _MTITLE = "MTitle";
	public static final String _MADDRESS = "MAddress";
	public static final String _MFEE = "MFee";

	protected void initDao() {
		// do nothing
	}

	public void save(TMeeting transientInstance) {
		log.debug("saving TMeeting instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TMeeting persistentInstance) {
		log.debug("deleting TMeeting instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TMeeting findById(java.lang.Integer id) {
		log.debug("getting TMeeting instance with id: " + id);
		try {
			TMeeting instance = (TMeeting) getHibernateTemplate().get(
					"org.wingame.dao.TMeeting", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TMeeting instance) {
		log.debug("finding TMeeting instance by example");
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
		log.debug("finding TMeeting instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TMeeting as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMTitle(Object MTitle) {
		return findByProperty(_MTITLE, MTitle);
	}

	public List findByMAddress(Object MAddress) {
		return findByProperty(_MADDRESS, MAddress);
	}

	public List findByMFee(Object MFee) {
		return findByProperty(_MFEE, MFee);
	}

	public List findAll() {
		log.debug("finding all TMeeting instances");
		try {
			String queryString = "from TMeeting";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TMeeting merge(TMeeting detachedInstance) {
		log.debug("merging TMeeting instance");
		try {
			TMeeting result = (TMeeting) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TMeeting instance) {
		log.debug("attaching dirty TMeeting instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TMeeting instance) {
		log.debug("attaching clean TMeeting instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TMeetingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TMeetingDAO) ctx.getBean("TMeetingDAO");
	}
}