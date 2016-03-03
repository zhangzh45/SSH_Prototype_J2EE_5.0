package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Searchkeyword entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.Searchkeyword
 * @author MyEclipse Persistence Tools
 */

public class SearchkeywordDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SearchkeywordDAO.class);
	// property constants
	public static final String KEYWORDNAME = "keywordname";
	public static final String KEYWORD = "keyword";
	public static final String KEYWORDVALUE = "keywordvalue";
	public static final String KEYWORDDESC = "keyworddesc";

	protected void initDao() {
		// do nothing
	}

	public void save(Searchkeyword transientInstance) {
		log.debug("saving Searchkeyword instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Searchkeyword persistentInstance) {
		log.debug("deleting Searchkeyword instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Searchkeyword findById(java.lang.Integer id) {
		log.debug("getting Searchkeyword instance with id: " + id);
		try {
			Searchkeyword instance = (Searchkeyword) getHibernateTemplate()
					.get("com.bean.Searchkeyword", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Searchkeyword instance) {
		log.debug("finding Searchkeyword instance by example");
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
		log.debug("finding Searchkeyword instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Searchkeyword as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByKeywordname(Object keywordname) {
		return findByProperty(KEYWORDNAME, keywordname);
	}

	public List findByKeyword(Object keyword) {
		return findByProperty(KEYWORD, keyword);
	}

	public List findByKeywordvalue(Object keywordvalue) {
		return findByProperty(KEYWORDVALUE, keywordvalue);
	}

	public List findByKeyworddesc(Object keyworddesc) {
		return findByProperty(KEYWORDDESC, keyworddesc);
	}

	public List findAll() {
		log.debug("finding all Searchkeyword instances");
		try {
			String queryString = "from Searchkeyword";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Searchkeyword merge(Searchkeyword detachedInstance) {
		log.debug("merging Searchkeyword instance");
		try {
			Searchkeyword result = (Searchkeyword) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Searchkeyword instance) {
		log.debug("attaching dirty Searchkeyword instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Searchkeyword instance) {
		log.debug("attaching clean Searchkeyword instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SearchkeywordDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SearchkeywordDAO) ctx.getBean("SearchkeywordDAO");
	}
}