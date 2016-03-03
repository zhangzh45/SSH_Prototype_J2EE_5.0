package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Serviceresult entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.Serviceresult
 * @author MyEclipse Persistence Tools
 */

public class ServiceresultDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ServiceresultDAO.class);
	// property constants
	public static final String RESULT_DESC = "resultDesc";
	public static final String RESULT_TYPE = "resultType";
	public static final String RESULT_NAME = "resultName";
	public static final String SERVICEID = "serviceid";

	protected void initDao() {
		// do nothing
	}

	public void save(Serviceresult transientInstance) {
		log.debug("saving Serviceresult instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Serviceresult persistentInstance) {
		log.debug("deleting Serviceresult instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Serviceresult findById(java.lang.Integer id) {
		log.debug("getting Serviceresult instance with id: " + id);
		try {
			Serviceresult instance = (Serviceresult) getHibernateTemplate()
					.get("com.bean.Serviceresult", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Serviceresult instance) {
		log.debug("finding Serviceresult instance by example");
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
		log.debug("finding Serviceresult instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Serviceresult as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByResultDesc(Object resultDesc) {
		return findByProperty(RESULT_DESC, resultDesc);
	}

	public List findByResultType(Object resultType) {
		return findByProperty(RESULT_TYPE, resultType);
	}

	public List findByResultName(Object resultName) {
		return findByProperty(RESULT_NAME, resultName);
	}

	public List findByServiceid(Object serviceid) {
		return findByProperty(SERVICEID, serviceid);
	}

	public List findAll() {
		log.debug("finding all Serviceresult instances");
		try {
			String queryString = "from Serviceresult";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Serviceresult merge(Serviceresult detachedInstance) {
		log.debug("merging Serviceresult instance");
		try {
			Serviceresult result = (Serviceresult) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Serviceresult instance) {
		log.debug("attaching dirty Serviceresult instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Serviceresult instance) {
		log.debug("attaching clean Serviceresult instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ServiceresultDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ServiceresultDAO) ctx.getBean("ServiceresultDAO");
	}
}