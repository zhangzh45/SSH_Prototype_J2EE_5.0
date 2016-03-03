package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Variable entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bean.Variable
 * @author MyEclipse Persistence Tools
 */

public class VariableDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(VariableDAO.class);
	// property constants
	public static final String SERVICE_ID = "service.serviceId";
	public static final String VARIABLE_NAME = "variableName";
	public static final String VARIABLE_DESC = "variableDesc";

	protected void initDao() {
		// do nothing
	}

	public void save(Variable transientInstance) {
		log.debug("saving Variable instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Variable persistentInstance) {
		log.debug("deleting Variable instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Variable findById(java.lang.Integer id) {
		log.debug("getting Variable instance with id: " + id);
		try {
			Variable instance = (Variable) getHibernateTemplate().get(
					"com.bean.Variable", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Variable instance) {
		log.debug("finding Variable instance by example");
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
		log.debug("finding Variable instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Variable as model where model."
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

	public List findByVariableName(Object variableName) {
		return findByProperty(VARIABLE_NAME, variableName);
	}

	public List findByVariableDesc(Object variableDesc) {
		return findByProperty(VARIABLE_DESC, variableDesc);
	}

	public List findAll() {
		log.debug("finding all Variable instances");
		try {
			String queryString = "from Variable";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Variable merge(Variable detachedInstance) {
		log.debug("merging Variable instance");
		try {
			Variable result = (Variable) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Variable instance) {
		log.debug("attaching dirty Variable instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Variable instance) {
		log.debug("attaching clean Variable instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VariableDAO getFromApplicationContext(ApplicationContext ctx) {
		return (VariableDAO) ctx.getBean("VariableDAO");
	}
}