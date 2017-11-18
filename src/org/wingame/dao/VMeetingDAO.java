package org.wingame.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * VMeeting entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.wingame.dao.VMeeting
 * @author MyEclipse Persistence Tools
 */

public class VMeetingDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(VMeetingDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(VMeeting transientInstance) {
		log.debug("saving VMeeting instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VMeeting persistentInstance) {
		log.debug("deleting VMeeting instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VMeeting findById(org.wingame.dao.VMeetingId id) {
		log.debug("getting VMeeting instance with id: " + id);
		try {
			VMeeting instance = (VMeeting) getHibernateTemplate().get(
					"org.wingame.dao.VMeeting", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VMeeting instance) {
		log.debug("finding VMeeting instance by example");
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
		log.debug("finding VMeeting instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from VMeeting as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all VMeeting instances");
		try {
			String queryString = "from VMeeting";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VMeeting merge(VMeeting detachedInstance) {
		log.debug("merging VMeeting instance");
		try {
			VMeeting result = (VMeeting) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VMeeting instance) {
		log.debug("attaching dirty VMeeting instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VMeeting instance) {
		log.debug("attaching clean VMeeting instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VMeetingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (VMeetingDAO) ctx.getBean("VMeetingDAO");
	}
}