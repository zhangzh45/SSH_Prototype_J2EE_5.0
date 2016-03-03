package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RolePermission entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.RolePermission
 * @author MyEclipse Persistence Tools
 */

public class RolePermissionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RolePermissionDAO.class);
	// property constants
	public static final String ROLE_ID = "role.roleId";
	public static final String PERMISSION_ID = "permission.permissionId";
	public static final String ROLE_PERMISSION_DESC = "rolePermissionDesc";

	protected void initDao() {
		// do nothing
	}

	public void save(RolePermission transientInstance) {
		log.debug("saving RolePermission instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RolePermission persistentInstance) {
		log.debug("deleting RolePermission instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RolePermission findById(java.lang.Integer id) {
		log.debug("getting RolePermission instance with id: " + id);
		try {
			RolePermission instance = (RolePermission) getHibernateTemplate()
					.get("com.bean.RolePermission", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RolePermission instance) {
		log.debug("finding RolePermission instance by example");
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
		log.debug("finding RolePermission instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RolePermission as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleId(Object roleId) {
		return findByProperty(ROLE_ID, roleId);
	}

	public List findByPermissionId(Object permissionId) {
		return findByProperty(PERMISSION_ID, permissionId);
	}

	public List findByRolePermissionDesc(Object rolePermissionDesc) {
		return findByProperty(ROLE_PERMISSION_DESC, rolePermissionDesc);
	}

	public List findAll() {
		log.debug("finding all RolePermission instances");
		try {
			String queryString = "from RolePermission";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RolePermission merge(RolePermission detachedInstance) {
		log.debug("merging RolePermission instance");
		try {
			RolePermission result = (RolePermission) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RolePermission instance) {
		log.debug("attaching dirty RolePermission instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RolePermission instance) {
		log.debug("attaching clean RolePermission instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RolePermissionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (RolePermissionDAO) ctx.getBean("RolePermissionDAO");
	}
}