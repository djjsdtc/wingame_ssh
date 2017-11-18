package org.wingame.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * VMeetingCount entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.wingame.dao.VMeetingCount
 * @author MyEclipse Persistence Tools
 */

public class VMeetingCountDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(VMeetingCountDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(VMeetingCount transientInstance) {
		log.debug("saving VMeetingCount instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VMeetingCount persistentInstance) {
		log.debug("deleting VMeetingCount instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VMeetingCount findById(org.wingame.dao.VMeetingCountId id) {
		log.debug("getting VMeetingCount instance with id: " + id);
		try {
			VMeetingCount instance = (VMeetingCount) getHibernateTemplate()
					.get("org.wingame.dao.VMeetingCount", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VMeetingCount instance) {
		log.debug("finding VMeetingCount instance by example");
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
		log.debug("finding VMeetingCount instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from VMeetingCount as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all VMeetingCount instances");
		try {
			String queryString = "from VMeetingCount";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VMeetingCount merge(VMeetingCount detachedInstance) {
		log.debug("merging VMeetingCount instance");
		try {
			VMeetingCount result = (VMeetingCount) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VMeetingCount instance) {
		log.debug("attaching dirty VMeetingCount instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VMeetingCount instance) {
		log.debug("attaching clean VMeetingCount instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VMeetingCountDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (VMeetingCountDAO) ctx.getBean("VMeetingCountDAO");
	}
}