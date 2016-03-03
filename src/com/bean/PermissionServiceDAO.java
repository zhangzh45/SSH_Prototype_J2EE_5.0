package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * PermissionService entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.PermissionService
 * @author MyEclipse Persistence Tools
 */

public class PermissionServiceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PermissionServiceDAO.class);
	// property constants
	public static final String PERMISSION_ID = "permission.permissionId";
	public static final String SERVICEID = "service.serviceId";
	public static final String PERMISION_SERVICE_DESC = "permisionServiceDesc";

	protected void initDao() {
		// do nothing
	}

	public void save(PermissionService transientInstance) {
		log.debug("saving PermissionService instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PermissionService persistentInstance) {
		log.debug("deleting PermissionService instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PermissionService findById(java.lang.Integer id) {
		log.debug("getting PermissionService instance with id: " + id);
		try {
			PermissionService instance = (PermissionService) getHibernateTemplate()
					.get("com.bean.PermissionService", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PermissionService instance) {
		log.debug("finding PermissionService instance by example");
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
		log.debug("finding PermissionService instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PermissionService as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPermissionId(Object permissionId) {
		return findByProperty(PERMISSION_ID, permissionId);
	}

	public List findByServiceid(Object serviceid) {
		return findByProperty(SERVICEID, serviceid);
	}

	public List findByPermisionServiceDesc(Object permisionServiceDesc) {
		return findByProperty(PERMISION_SERVICE_DESC, permisionServiceDesc);
	}

	public List findAll() {
		log.debug("finding all PermissionService instances");
		try {
			String queryString = "from PermissionService";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PermissionService merge(PermissionService detachedInstance) {
		log.debug("merging PermissionService instance");
		try {
			PermissionService result = (PermissionService) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PermissionService instance) {
		log.debug("attaching dirty PermissionService instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PermissionService instance) {
		log.debug("attaching clean PermissionService instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PermissionServiceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PermissionServiceDAO) ctx.getBean("PermissionServiceDAO");
	}
}