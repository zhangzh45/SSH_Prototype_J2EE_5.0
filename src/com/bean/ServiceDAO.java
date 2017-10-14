package com.bean;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Service entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bean.Service
 * @author MyEclipse Persistence Tools
 */

public class ServiceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ServiceDAO.class);
	// property constants
	public static final String SERVICE_NAME = "serviceName";
	public static final String SERVICE_DESC = "serviceDesc";
	public static final String MAX_LOAD = "maxLoad";
	public static final String SERVICE_TYPE = "serviceType";
	public static final String SERVICE_LEVEL = "serviceLevel";
	public static final String RELATE_BUSINESS = "relateBusiness";
	public static final String SERVICE_TARGET = "serviceTarget";
	public static final String SERVICE_RANGE = "serviceRange";
	public static final String SERVICE_STATE = "serviceState";
	public static final String SERVICE_ADDRESS = "serviceAddress";
	public static final String SERVICE_VERSION = "serviceVersion";
	public static final String SERVICE_MAKER = "serviceMaker";
	public static final String SERVICE_TIME = "serviceTime";
	public static final String SERVICE_HOST = "serviceHost";
	public static final String SERVICE_QUERY = "serviceQuery";
	public static final String RUN_TIMES = "runTimes";
	public static final String FAIL_TIMES = "failTimes";
	public static final String CALL_SERVICE = "callService";
	public static final String SERVICE_PROVIDER = "serviceProvider";
	public static final String APP_ROLE_URL = "appRoleUrl";
	public static final String BUSINESS_FILE = "businessFile";
	public static final String COMBINE_TYPE = "combineType";
	public static final String ATTACHMENTS = "attachments";
	public static final String IS_EXTERNAL = "isExternal";

	protected void initDao() {
		// do nothing
	}

	public void save(Service transientInstance) {
		log.debug("saving Service instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Service persistentInstance) {
		log.debug("deleting Service instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Service findById(java.lang.Integer id) {
		log.debug("getting Service instance with id: " + id);
		try {
			Service instance = (Service) getHibernateTemplate().get(
					"com.bean.Service", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Service instance) {
		log.debug("finding Service instance by example");
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
		log.debug("finding Service instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Service as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByServiceName(Object serviceName) {
		return findByProperty(SERVICE_NAME, serviceName);
	}

	public List findByServiceDesc(Object serviceDesc) {
		return findByProperty(SERVICE_DESC, serviceDesc);
	}

	public List findByMaxLoad(Object maxLoad) {
		return findByProperty(MAX_LOAD, maxLoad);
	}

	public List findByServiceType(Object serviceType) {
		return findByProperty(SERVICE_TYPE, serviceType);
	}

	public List findByServiceLevel(Object serviceLevel) {
		return findByProperty(SERVICE_LEVEL, serviceLevel);
	}

	public List findByRelateBusiness(Object relateBusiness) {
		return findByProperty(RELATE_BUSINESS, relateBusiness);
	}

	public List findByServiceTarget(Object serviceTarget) {
		return findByProperty(SERVICE_TARGET, serviceTarget);
	}

	public List findByServiceRange(Object serviceRange) {
		return findByProperty(SERVICE_RANGE, serviceRange);
	}

	public List findByServiceState(Object serviceState) {
		return findByProperty(SERVICE_STATE, serviceState);
	}

	public List findByServiceAddress(Object serviceAddress) {
		return findByProperty(SERVICE_ADDRESS, serviceAddress);
	}

	public List findByServiceVersion(Object serviceVersion) {
		return findByProperty(SERVICE_VERSION, serviceVersion);
	}

	public List findByServiceMaker(Object serviceMaker) {
		return findByProperty(SERVICE_MAKER, serviceMaker);
	}

	public List findByServiceTime(Object serviceTime) {
		return findByProperty(SERVICE_TIME, serviceTime);
	}

	public List findByServiceHost(Object serviceHost) {
		return findByProperty(SERVICE_HOST, serviceHost);
	}

	public List findByServiceQuery(Object serviceQuery) {
		return findByProperty(SERVICE_QUERY, serviceQuery);
	}

	public List findByRunTimes(Object runTimes) {
		return findByProperty(RUN_TIMES, runTimes);
	}

	public List findByFailTimes(Object failTimes) {
		return findByProperty(FAIL_TIMES, failTimes);
	}

	public List findByCallService(Object callService) {
		return findByProperty(CALL_SERVICE, callService);
	}

	public List findByServiceProvider(Object serviceProvider) {
		return findByProperty(SERVICE_PROVIDER, serviceProvider);
	}

	public List findByAppRoleUrl(Object appRoleUrl) {
		return findByProperty(APP_ROLE_URL, appRoleUrl);
	}

	public List findByBusinessFile(Object businessFile) {
		return findByProperty(BUSINESS_FILE, businessFile);
	}

	public List findByCombineType(Object combineType) {
		return findByProperty(COMBINE_TYPE, combineType);
	}

	public List findByAttachments(Object attachments) {
		return findByProperty(ATTACHMENTS, attachments);
	}

	public List findByIsExternal(Object isExternal) {
		return findByProperty(IS_EXTERNAL, isExternal);
	}

	public List findAll() {
		log.debug("finding all Service instances");
		try {
			String queryString = "from Service";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Service merge(Service detachedInstance) {
		log.debug("merging Service instance");
		try {
			Service result = (Service) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Service instance) {
		log.debug("attaching dirty Service instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Service instance) {
		log.debug("attaching clean Service instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ServiceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ServiceDAO) ctx.getBean("ServiceDAO");
	}
	
	
	/*
	 * @method findParmById
	 * function:at the time  find the service by serviceId that can load the service's parameter information
	 * */
		public Service findParmById(int id){
			try{
			String sql="select sr from Service sr left join fetch sr.parameters where sr.serviceId=?";
			List<Service> list=getHibernateTemplate().find(sql, id);
			return list.get(0);
			}catch(RuntimeException re) {
				log.error("get failed", re);
				throw re;
			}
		}
	
	public List<Service> orderByRuntimes() {
		String hql="select distinct ser from Service ser order by ser.runTimes desc, ser.serviceId asc";
		System.out.print("hql:");
		return getHibernateTemplate().find(hql);
	}
	
	public List<String> findServiceType() {
		String hql="select distinct serviceType from Service";
		return getHibernateTemplate().find(hql);
	}
	
	public List<String> findRelateBusiness() {
		String hql="select distinct relateBusiness from Service";
		return getHibernateTemplate().find(hql);
	}
}