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
 * RoleSpecSer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.RoleSpecSer
 * @author MyEclipse Persistence Tools
 */

public class RoleSpecSerDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(RoleSpecSerDAO.class);
	// property constants
	public static final String ROLE_ID="role.roleId";
	public static final String OPERATOR_NAME = "operatorName";
	public static final String DESCRIP = "descrip";

	protected void initDao() {
		// do nothing
	}

	public void save(RoleSpecSer transientInstance) {
		log.debug("saving RoleSpecSer instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoleSpecSer persistentInstance) {
		log.debug("deleting RoleSpecSer instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoleSpecSer findById(java.lang.Integer id) {
		log.debug("getting RoleSpecSer instance with id: " + id);
		try {
			RoleSpecSer instance = (RoleSpecSer) getHibernateTemplate().get(
					"com.bean.RoleSpecSer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RoleSpecSer instance) {
		log.debug("finding RoleSpecSer instance by example");
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
		log.debug("finding RoleSpecSer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RoleSpecSer as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<RoleSpecSer> findSpecSerByRoleId(int roleId){
		String sql="select rss from RoleSpecSer rss inner join fetch rss.service r left join fetch r.parameters where rss.role.roleId=?";
		return  getHibernateTemplate().find(sql, roleId);
	
	}
	
	public List<RoleSpecSer> findSpecSerByServiceId(int serviceId){
		String sql="select rss from RoleSpecSer rss inner join fetch rss.service r where rss.service.serviceId=?";
		return  getHibernateTemplate().find(sql, serviceId);
	
	}

	public List findByOperatorName(Object operatorName) {
		return findByProperty(OPERATOR_NAME, operatorName);
	}

	public List findByDescrip(Object descrip) {
		return findByProperty(DESCRIP, descrip);
	}

	public List<RoleSpecSer> findAll() {
		log.debug("finding all RoleSpecSer instances");
		try {
			String queryString = "from RoleSpecSer rss inner join fetch rss.role inner join fetch rss.service";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoleSpecSer merge(RoleSpecSer detachedInstance) {
		log.debug("merging RoleSpecSer instance");
		try {
			RoleSpecSer result = (RoleSpecSer) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RoleSpecSer instance) {
		log.debug("attaching dirty RoleSpecSer instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoleSpecSer instance) {
		log.debug("attaching clean RoleSpecSer instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoleSpecSerDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (RoleSpecSerDAO) ctx.getBean("RoleSpecSerDAO");
	}
}