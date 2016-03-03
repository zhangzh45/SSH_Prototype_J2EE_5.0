package com.bean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserSpecSer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.UserSpecSer
 * @author MyEclipse Persistence Tools
 */

public class UserSpecSerDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UserSpecSerDAO.class);
	// property constants
	public static final String USER_ID="user.userId";
	public static final String SERVICE_ID="service.serviceId";
	public static final String OPERATER_NAME = "operaterName";
	public static final String DESCRIP = "descrip";

	protected void initDao() {
		// do nothing
	}

	public void save(UserSpecSer transientInstance) {
		log.debug("saving UserSpecSer instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserSpecSer persistentInstance) {
		log.debug("deleting UserSpecSer instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserSpecSer findById(java.lang.Integer id) {
		log.debug("getting UserSpecSer instance with id: " + id);
		try {
			UserSpecSer instance = (UserSpecSer) getHibernateTemplate().get(
					"com.bean.UserSpecSer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserSpecSer instance) {
		log.debug("finding UserSpecSer instance by example");
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
		log.debug("finding UserSpecSer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserSpecSer as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<UserSpecSer> findSpecSerByUserId(int userId){
		//String hql="select u from User u inner join fetch u.userRoles r inner join fetch r.role ro inner join fetch ro.rolePermissions where u.userId=?";
		String hql="select distinct uss from UserSpecSer uss inner join fetch uss.service s left join fetch s.parameters where uss.user.userId=?";
		return getHibernateTemplate().find(hql, userId);
		
	}
	
	public List findByOperaterName(Object operaterName) {
		return findByProperty(OPERATER_NAME, operaterName);
	}

	public List findByDescrip(Object descrip) {
		return findByProperty(DESCRIP, descrip);
	}

	public List findAll() {
		log.debug("finding all UserSpecSer instances");
		try {
			String queryString = "from UserSpecSer";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserSpecSer merge(UserSpecSer detachedInstance) {
		log.debug("merging UserSpecSer instance");
		try {
			UserSpecSer result = (UserSpecSer) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserSpecSer instance) {
		log.debug("attaching dirty UserSpecSer instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserSpecSer instance) {
		log.debug("attaching clean UserSpecSer instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserSpecSerDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserSpecSerDAO) ctx.getBean("UserSpecSerDAO");
	}
	
	public void deleteByServiceUserId( int serviceId, int userId) {
	
		try {
		
			String queryString = "from UserSpecSer as model where model."
					+SERVICE_ID+ "= ? and model." 
					+USER_ID+"= ?";
			/*String hql="delete from UserSpecSer as m where model."
					+SERVICE_ID+ "= ? and model." 
					+USER_ID+"= ?";*/
			List<UserSpecSer> list= getHibernateTemplate().find(queryString, serviceId,userId);
		    UserSpecSer usss=list.get(0);
		    //getHibernateTemplate().getSessionFactory().evictQueries();
			delete(usss);
			/*Query query=getSession().createQuery(hql); 
			query.setParameter(0, serviceId);
			query.setParameter(1, userId);
			int i=query.executeUpdate();
			System.out.println(i);*/
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
	}
	}
}