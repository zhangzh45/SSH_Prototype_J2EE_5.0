package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Searchinf entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bean.Searchinf
 * @author MyEclipse Persistence Tools
 */

public class SearchinfDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SearchinfDAO.class);
	// property constants
	public static final String INF = "inf";
	public static final String VALUE = "value";

	protected void initDao() {
		// do nothing
	}

	public void save(Searchinf transientInstance) {
		log.debug("saving Searchinf instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Searchinf persistentInstance) {
		log.debug("deleting Searchinf instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Searchinf findById(java.lang.Integer id) {
		log.debug("getting Searchinf instance with id: " + id);
		try {
			Searchinf instance = (Searchinf) getHibernateTemplate().get(
					"com.bean.Searchinf", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Searchinf instance) {
		log.debug("finding Searchinf instance by example");
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
		log.debug("finding Searchinf instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Searchinf as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInf(Object inf) {
		return findByProperty(INF, inf);
	}

	public List findByValue(Object value) {
		return findByProperty(VALUE, value);
	}

	public List findAll() {
		log.debug("finding all Searchinf instances");
		try {
			String queryString = "from Searchinf";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Searchinf merge(Searchinf detachedInstance) {
		log.debug("merging Searchinf instance");
		try {
			Searchinf result = (Searchinf) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Searchinf instance) {
		log.debug("attaching dirty Searchinf instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Searchinf instance) {
		log.debug("attaching clean Searchinf instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SearchinfDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SearchinfDAO) ctx.getBean("SearchinfDAO");
	}
}