package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * SpecTaskRoleUser entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.SpecTaskRoleUser
 * @author MyEclipse Persistence Tools
 */

public class SpecTaskRoleUserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SpecTaskRoleUserDAO.class);
	// property constants
	public static final String SPEC_IDENTIFIER = "specIdentifier";
	public static final String TASK_ID = "taskId";
	public static final String TASK_NAME = "taskName";
	public static final String ROLE_ID = "roleId";
	public static final String PARTICIPANT_ID = "participantId";

	protected void initDao() {
		// do nothing
	}

	public void save(SpecTaskRoleUser transientInstance) {
		log.debug("saving SpecTaskRoleUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SpecTaskRoleUser persistentInstance) {
		log.debug("deleting SpecTaskRoleUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SpecTaskRoleUser findById(java.lang.Integer id) {
		log.debug("getting SpecTaskRoleUser instance with id: " + id);
		try {
			SpecTaskRoleUser instance = (SpecTaskRoleUser) getHibernateTemplate()
					.get("com.bean.SpecTaskRoleUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SpecTaskRoleUser instance) {
		log.debug("finding SpecTaskRoleUser instance by example");
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
		log.debug("finding SpecTaskRoleUser instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SpecTaskRoleUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySpecIdentifier(Object specIdentifier) {
		return findByProperty(SPEC_IDENTIFIER, specIdentifier);
	}

	public List findByTaskId(Object taskId) {
		return findByProperty(TASK_ID, taskId);
	}

	public List findByTaskName(Object taskName) {
		return findByProperty(TASK_NAME, taskName);
	}

	public List findByRoleId(Object roleId) {
		return findByProperty(ROLE_ID, roleId);
	}

	public List findByParticipantId(Object participantId) {
		return findByProperty(PARTICIPANT_ID, participantId);
	}

	public List findAll() {
		log.debug("finding all SpecTaskRoleUser instances");
		try {
			String queryString = "from SpecTaskRoleUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SpecTaskRoleUser merge(SpecTaskRoleUser detachedInstance) {
		log.debug("merging SpecTaskRoleUser instance");
		try {
			SpecTaskRoleUser result = (SpecTaskRoleUser) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SpecTaskRoleUser instance) {
		log.debug("attaching dirty SpecTaskRoleUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SpecTaskRoleUser instance) {
		log.debug("attaching clean SpecTaskRoleUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SpecTaskRoleUserDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SpecTaskRoleUserDAO) ctx.getBean("SpecTaskRoleUserDAO");
	}
}