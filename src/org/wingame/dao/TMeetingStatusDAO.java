package org.wingame.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TMeetingStatus entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.wingame.dao.TMeetingStatus
 * @author MyEclipse Persistence Tools
 */

public class TMeetingStatusDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TMeetingStatusDAO.class);
	// property constants
	public static final String PAYWAY = "payway";

	protected void initDao() {
		// do nothing
	}

	public void save(TMeetingStatus transientInstance) {
		log.debug("saving TMeetingStatus instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TMeetingStatus persistentInstance) {
		log.debug("deleting TMeetingStatus instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TMeetingStatus findById(org.wingame.dao.TMeetingStatusId id) {
		log.debug("getting TMeetingStatus instance with id: " + id);
		try {
			TMeetingStatus instance = (TMeetingStatus) getHibernateTemplate()
					.get("org.wingame.dao.TMeetingStatus", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TMeetingStatus instance) {
		log.debug("finding TMeetingStatus instance by example");
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
		log.debug("finding TMeetingStatus instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TMeetingStatus as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPayway(Object payway) {
		return findByProperty(PAYWAY, payway);
	}

	public List findAll() {
		log.debug("finding all TMeetingStatus instances");
		try {
			String queryString = "from TMeetingStatus";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TMeetingStatus merge(TMeetingStatus detachedInstance) {
		log.debug("merging TMeetingStatus instance");
		try {
			TMeetingStatus result = (TMeetingStatus) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TMeetingStatus instance) {
		log.debug("attaching dirty TMeetingStatus instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TMeetingStatus instance) {
		log.debug("attaching clean TMeetingStatus instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TMeetingStatusDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TMeetingStatusDAO) ctx.getBean("TMeetingStatusDAO");
	}
}