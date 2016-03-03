package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Condition entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bean.Condition
 * @author MyEclipse Persistence Tools
 */

public class ConditionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ConditionDAO.class);
	// property constants
	public static final String SERVICE_ID = "serviceByServiceId.serviceId";
	public static final String CONDTION_EXPRESSION = "condtionExpression";
	public static final String SUB_SERVICE_ID = "serviceBySubServiceId.serviceId";

	protected void initDao() {
		// do nothing
	}

	public void save(Condition transientInstance) {
		log.debug("saving Condition instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Condition persistentInstance) {
		log.debug("deleting Condition instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Condition findById(java.lang.Integer id) {
		log.debug("getting Condition instance with id: " + id);
		try {
			Condition instance = (Condition) getHibernateTemplate().get(
					"com.bean.Condition", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Condition instance) {
		log.debug("finding Condition instance by example");
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
		log.debug("finding Condition instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Condition as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByServiceId(Object serviceId) {
		return findByProperty(SERVICE_ID, serviceId);
	}

	public List findByCondtionExpression(Object condtionExpression) {
		return findByProperty(CONDTION_EXPRESSION, condtionExpression);
	}

	public List findBySubServiceId(Object subServiceId) {
		return findByProperty(SUB_SERVICE_ID, subServiceId);
	}

	public List findAll() {
		log.debug("finding all Condition instances");
		try {
			String queryString = "from Condition";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Condition merge(Condition detachedInstance) {
		log.debug("merging Condition instance");
		try {
			Condition result = (Condition) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Condition instance) {
		log.debug("attaching dirty Condition instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Condition instance) {
		log.debug("attaching clean Condition instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ConditionDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ConditionDAO) ctx.getBean("ConditionDAO");
	}
}