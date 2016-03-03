package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Licence entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bean.Licence
 * @author MyEclipse Persistence Tools
 */

public class LicenceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(LicenceDAO.class);
	// property constants
	public static final String LICENCE_TYPE = "licenceType";
	public static final String LICENCE_TIME = "licenceTime";
	public static final String LICENCE_CODE = "licenceCode";
	public static final String LICENCE_LOCATION = "licenceLocation";

	protected void initDao() {
		// do nothing
	}

	public void save(Licence transientInstance) {
		log.debug("saving Licence instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Licence persistentInstance) {
		log.debug("deleting Licence instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Licence findById(java.lang.Integer id) {
		log.debug("getting Licence instance with id: " + id);
		try {
			Licence instance = (Licence) getHibernateTemplate().get(
					"com.bean.Licence", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Licence instance) {
		log.debug("finding Licence instance by example");
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
		log.debug("finding Licence instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Licence as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLicenceType(Object licenceType) {
		return findByProperty(LICENCE_TYPE, licenceType);
	}

	public List findByLicenceTime(Object licenceTime) {
		return findByProperty(LICENCE_TIME, licenceTime);
	}

	public List findByLicenceCode(Object licenceCode) {
		return findByProperty(LICENCE_CODE, licenceCode);
	}

	public List findByLicenceLocation(Object licenceLocation) {
		return findByProperty(LICENCE_LOCATION, licenceLocation);
	}

	public List findAll() {
		log.debug("finding all Licence instances");
		try {
			String queryString = "from Licence";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Licence merge(Licence detachedInstance) {
		log.debug("merging Licence instance");
		try {
			Licence result = (Licence) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Licence instance) {
		log.debug("attaching dirty Licence instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Licence instance) {
		log.debug("attaching clean Licence instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LicenceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LicenceDAO) ctx.getBean("LicenceDAO");
	}
}