package org.wingame.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAnnounce entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.wingame.dao.TAnnounce
 * @author MyEclipse Persistence Tools
 */

public class TAnnounceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TAnnounceDAO.class);
	// property constants
	public static final String ANN_TITLE = "annTitle";
	public static final String ANN_TEXT = "annText";

	protected void initDao() {
		// do nothing
	}

	public void save(TAnnounce transientInstance) {
		log.debug("saving TAnnounce instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TAnnounce persistentInstance) {
		log.debug("deleting TAnnounce instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TAnnounce findById(java.lang.Integer id) {
		log.debug("getting TAnnounce instance with id: " + id);
		try {
			TAnnounce instance = (TAnnounce) getHibernateTemplate().get(
					"org.wingame.dao.TAnnounce", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TAnnounce instance) {
		log.debug("finding TAnnounce instance by example");
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
		log.debug("finding TAnnounce instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TAnnounce as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAnnTitle(Object annTitle) {
		return findByProperty(ANN_TITLE, annTitle);
	}

	public List findByAnnText(Object annText) {
		return findByProperty(ANN_TEXT, annText);
	}

	public List findAll() {
		log.debug("finding all TAnnounce instances");
		try {
			String queryString = "from TAnnounce";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TAnnounce merge(TAnnounce detachedInstance) {
		log.debug("merging TAnnounce instance");
		try {
			TAnnounce result = (TAnnounce) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAnnounce instance) {
		log.debug("attaching dirty TAnnounce instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAnnounce instance) {
		log.debug("attaching clean TAnnounce instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAnnounceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TAnnounceDAO) ctx.getBean("TAnnounceDAO");
	}
}