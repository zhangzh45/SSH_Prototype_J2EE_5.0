package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Serviceclass entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.Serviceclass
 * @author MyEclipse Persistence Tools
 */

public class ServiceclassDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ServiceclassDAO.class);
	// property constants
	public static final String SERVICESNUM = "servicesnum";
	public static final String SERVICES = "services";

	protected void initDao() {
		// do nothing
	}

	public void save(Serviceclass transientInstance) {
		log.debug("saving Serviceclass instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Serviceclass persistentInstance) {
		log.debug("deleting Serviceclass instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Serviceclass findById(com.bean.ServiceclassId id) {
		log.debug("getting Serviceclass instance with id: " + id);
		try {
			Serviceclass instance = (Serviceclass) getHibernateTemplate().get(
					"com.bean.Serviceclass", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Serviceclass instance) {
		log.debug("finding Serviceclass instance by example");
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
		log.debug("finding Serviceclass instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Serviceclass as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByServicesnum(Object servicesnum) {
		return findByProperty(SERVICESNUM, servicesnum);
	}

	public List findByServices(Object services) {
		return findByProperty(SERVICES, services);
	}

	public List findAll() {
		log.debug("finding all Serviceclass instances");
		try {
			String queryString = "from Serviceclass";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 查找服务类的种类数目
	 * @return
	 */
	public int findServiceclassesNum() {
		log.debug("finding all Serviceclass instances");
		try {
			String queryString = "from Serviceclass";
			return getHibernateTemplate().find(queryString).size();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 查找该功能的服务类是否存在
	 * @return
	 */
	public boolean isExisted(com.bean.ServiceclassId id) {
		if(findById(id) == null){
			return false;
		}
		return true;
	}

	public Serviceclass merge(Serviceclass detachedInstance) {
		log.debug("merging Serviceclass instance");
		try {
			Serviceclass result = (Serviceclass) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Serviceclass instance) {
		log.debug("attaching dirty Serviceclass instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Serviceclass instance) {
		log.debug("attaching clean Serviceclass instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ServiceclassDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ServiceclassDAO) ctx.getBean("ServiceclassDAO");
	}
}