package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Searchsite entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bean.Searchsite
 * @author MyEclipse Persistence Tools
 */

public class SearchsiteDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SearchsiteDAO.class);
	// property constants
	public static final String ADDRESS = "address";
	public static final String PAGECONTROL = "pagecontrol";
	public static final String SUPPLIER = "supplier";
	public static final String AREA = "area";

	protected void initDao() {
		// do nothing
	}

	public void save(Searchsite transientInstance) {
		log.debug("saving Searchsite instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Searchsite persistentInstance) {
		log.debug("deleting Searchsite instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Searchsite findById(java.lang.Integer id) {
		log.debug("getting Searchsite instance with id: " + id);
		try {
			Searchsite instance = (Searchsite) getHibernateTemplate().get(
					"com.bean.Searchsite", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Searchsite instance) {
		log.debug("finding Searchsite instance by example");
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
		log.debug("finding Searchsite instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Searchsite as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByPagecontrol(Object pagecontrol) {
		return findByProperty(PAGECONTROL, pagecontrol);
	}

	public List findBySupplier(Object supplier) {
		return findByProperty(SUPPLIER, supplier);
	}

	public List findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findAll() {
		log.debug("finding all Searchsite instances");
		try {
			String queryString = "from Searchsite";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Searchsite merge(Searchsite detachedInstance) {
		log.debug("merging Searchsite instance");
		try {
			Searchsite result = (Searchsite) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Searchsite instance) {
		log.debug("attaching dirty Searchsite instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Searchsite instance) {
		log.debug("attaching clean Searchsite instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SearchsiteDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SearchsiteDAO) ctx.getBean("SearchsiteDAO");
	}
}