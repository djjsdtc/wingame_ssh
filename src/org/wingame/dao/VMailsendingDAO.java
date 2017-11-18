package org.wingame.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * VMailsending entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.wingame.dao.VMailsending
 * @author MyEclipse Persistence Tools
 */

public class VMailsendingDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(VMailsendingDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(VMailsending transientInstance) {
		log.debug("saving VMailsending instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VMailsending persistentInstance) {
		log.debug("deleting VMailsending instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VMailsending findById(org.wingame.dao.VMailsendingId id) {
		log.debug("getting VMailsending instance with id: " + id);
		try {
			VMailsending instance = (VMailsending) getHibernateTemplate().get(
					"org.wingame.dao.VMailsending", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VMailsending instance) {
		log.debug("finding VMailsending instance by example");
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
		log.debug("finding VMailsending instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from VMailsending as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all VMailsending instances");
		try {
			String queryString = "from VMailsending";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VMailsending merge(VMailsending detachedInstance) {
		log.debug("merging VMailsending instance");
		try {
			VMailsending result = (VMailsending) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VMailsending instance) {
		log.debug("attaching dirty VMailsending instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VMailsending instance) {
		log.debug("attaching clean VMailsending instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VMailsendingDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (VMailsendingDAO) ctx.getBean("VMailsendingDAO");
	}
}