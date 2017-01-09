package com.bean;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Runlog entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bean.Runlog
 * @author MyEclipse Persistence Tools
 */

public class RunlogDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(RunlogDAO.class);
	// property constants
	public static final String SERVICEID = "serviceid";
	public static final String USERID = "userid";
	public static final String RUNSTATE = "runstate";
	public static final String RUNDESC = "rundesc";

	protected void initDao() {
		// do nothing
	}

	public void save(Runlog transientInstance) {
		log.debug("saving Runlog instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Runlog persistentInstance) {
		log.debug("deleting Runlog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Runlog findById(java.lang.Integer id) {
		log.debug("getting Runlog instance with id: " + id);
		try {
			Runlog instance = (Runlog) getHibernateTemplate().get(
					"com.bean.Runlog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Runlog instance) {
		log.debug("finding Runlog instance by example");
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
		log.debug("finding Runlog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Runlog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByServiceid(Object serviceid) {
		return findByProperty(SERVICEID, serviceid);
	}

	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	public List findByRunstate(Object runstate) {
		return findByProperty(RUNSTATE, runstate);
	}

	public List findByRundesc(Object rundesc) {
		return findByProperty(RUNDESC, rundesc);
	}

	public List findAll() {
		log.debug("finding all Runlog instances");
		try {
			String queryString = "from Runlog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Runlog merge(Runlog detachedInstance) {
		log.debug("merging Runlog instance");
		try {
			Runlog result = (Runlog) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Runlog instance) {
		log.debug("attaching dirty Runlog instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Runlog instance) {
		log.debug("attaching clean Runlog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RunlogDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RunlogDAO) ctx.getBean("RunlogDAO");
	}
}