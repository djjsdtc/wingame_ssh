package org.wingame.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TDocument entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.wingame.dao.TDocument
 * @author MyEclipse Persistence Tools
 */

public class TDocumentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TDocumentDAO.class);
	// property constants
	public static final String DOC_FILENAME = "docFilename";
	public static final String DOC_STATUS = "docStatus";

	protected void initDao() {
		// do nothing
	}

	public void save(TDocument transientInstance) {
		log.debug("saving TDocument instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDocument persistentInstance) {
		log.debug("deleting TDocument instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDocument findById(org.wingame.dao.TDocumentId id) {
		log.debug("getting TDocument instance with id: " + id);
		try {
			TDocument instance = (TDocument) getHibernateTemplate().get(
					"org.wingame.dao.TDocument", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TDocument instance) {
		log.debug("finding TDocument instance by example");
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
		log.debug("finding TDocument instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TDocument as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDocFilename(Object docFilename) {
		return findByProperty(DOC_FILENAME, docFilename);
	}

	public List findByDocStatus(Object docStatus) {
		return findByProperty(DOC_STATUS, docStatus);
	}

	public List findAll() {
		log.debug("finding all TDocument instances");
		try {
			String queryString = "from TDocument";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDocument merge(TDocument detachedInstance) {
		log.debug("merging TDocument instance");
		try {
			TDocument result = (TDocument) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDocument instance) {
		log.debug("attaching dirty TDocument instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDocument instance) {
		log.debug("attaching clean TDocument instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TDocumentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TDocumentDAO) ctx.getBean("TDocumentDAO");
	}
}