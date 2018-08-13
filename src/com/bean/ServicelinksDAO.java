package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Servicelinks entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.bean.Servicelinks
  * @author MyEclipse Persistence Tools 
 */

public class ServicelinksDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ServicelinksDAO.class);
		//property constants
	public static final String SERVICE_ID = "serviceId";
	public static final String SUB_SERVICE_ID = "subServiceId";
	public static final String PARENT_APP_ID = "parentAppId";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Servicelinks transientInstance) {
        log.debug("saving Servicelinks instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Servicelinks persistentInstance) {
        log.debug("deleting Servicelinks instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Servicelinks findById( java.lang.Integer id) {
        log.debug("getting Servicelinks instance with id: " + id);
        try {
            Servicelinks instance = (Servicelinks) getHibernateTemplate()
                    .get("com.bean.Servicelinks", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Servicelinks instance) {
        log.debug("finding Servicelinks instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Servicelinks instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Servicelinks as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByServiceId(Object serviceId) {
		return findByProperty(SERVICE_ID, serviceId
		);
	}
	
	public List findBySubServiceId(Object subServiceId) {
		return findByProperty(SUB_SERVICE_ID, subServiceId
		);
	}
	
	public List findByParentAppId(Object parentAppId) {
		return findByProperty(PARENT_APP_ID, parentAppId
		);
	}
	

	public List findAll() {
		log.debug("finding all Servicelinks instances");
		try {
			String queryString = "from Servicelinks";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Servicelinks merge(Servicelinks detachedInstance) {
        log.debug("merging Servicelinks instance");
        try {
            Servicelinks result = (Servicelinks) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Servicelinks instance) {
        log.debug("attaching dirty Servicelinks instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Servicelinks instance) {
        log.debug("attaching clean Servicelinks instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ServicelinksDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ServicelinksDAO) ctx.getBean("ServicelinksDAO");
	}
}