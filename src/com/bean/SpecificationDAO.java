package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Specification entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.bean.Specification
 * @author MyEclipse Persistence Tools
 */

public class SpecificationDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SpecificationDAO.class);
	// property constants
	public static final String IDENTIFIER = "identifier";
	public static final String NAME = "name";
	public static final String URI = "uri";
	public static final String VERSION = "version";
	public static final String DESCRIPTION = "description";
	public static final String XML = "xml";
	public static final String FILEPATH = "filepath";

	protected void initDao() {
		// do nothing
	}

	public void save(Specification transientInstance) {
		log.debug("saving Specification instance");
		try {
			System.out.print("getHibernateTemplate:"+getHibernateTemplate());
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Specification persistentInstance) {
		log.debug("deleting Specification instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Specification findById(java.lang.Integer id) {
		log.debug("getting Specification instance with id: " + id);
		try {
			Specification instance = (Specification) getHibernateTemplate()
					.get("com.bean.Specification", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Specification instance) {
		log.debug("finding Specification instance by example");
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
		log.debug("finding Specification instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Specification as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIdentifier(Object identifier) {
		return findByProperty(IDENTIFIER, identifier);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByUri(Object uri) {
		return findByProperty(URI, uri);
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByXml(Object xml) {
		return findByProperty(XML, xml);
	}

	public List findByFilepath(Object filepath) {
		return findByProperty(FILEPATH, filepath);
	}

	public List findAll() {
		log.debug("finding all Specification instances");
		try {
			String queryString = "from Specification";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Specification merge(Specification detachedInstance) {
		log.debug("merging Specification instance");
		try {
			Specification result = (Specification) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Specification instance) {
		log.debug("attaching dirty Specification instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Specification instance) {
		log.debug("attaching clean Specification instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SpecificationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SpecificationDAO) ctx.getBean("SpecificationDAO");
	}
}