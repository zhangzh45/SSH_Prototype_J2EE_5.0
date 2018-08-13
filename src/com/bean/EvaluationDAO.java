package com.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Evaluation entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bean.Evaluation
 * @author MyEclipse Persistence Tools
 */

public class EvaluationDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(EvaluationDAO.class);
	// property constants
	public static final String EVALUATION_USER = "evaluationUser";
	public static final String EVALUATION_SERVICE = "evaluationService";
	public static final String EVALUATION_MARK = "evaluationMark";
	public static final String SUGGESTION = "suggestion";

	protected void initDao() {
		// do nothing
	}

	public void save(Evaluation transientInstance) {
		log.debug("saving Evaluation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Evaluation persistentInstance) {
		log.debug("deleting Evaluation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Evaluation findById(java.lang.Integer id) {
		log.debug("getting Evaluation instance with id: " + id);
		try {
			Evaluation instance = (Evaluation) getHibernateTemplate().get(
					"com.bean.Evaluation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Evaluation instance) {
		log.debug("finding Evaluation instance by example");
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
		log.debug("finding Evaluation instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Evaluation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEvaluationUser(Object evaluationUser) {
		return findByProperty(EVALUATION_USER, evaluationUser);
	}

	public List findByEvaluationService(Object evaluationService) {
		return findByProperty(EVALUATION_SERVICE, evaluationService);
	}

	public List findByEvaluationMark(Object evaluationMark) {
		return findByProperty(EVALUATION_MARK, evaluationMark);
	}

	public List findBySuggestion(Object suggestion) {
		return findByProperty(SUGGESTION, suggestion);
	}

	public List findAll() {
		log.debug("finding all Evaluation instances");
		try {
			String queryString = "from Evaluation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Evaluation merge(Evaluation detachedInstance) {
		log.debug("merging Evaluation instance");
		try {
			Evaluation result = (Evaluation) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Evaluation instance) {
		log.debug("attaching dirty Evaluation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Evaluation instance) {
		log.debug("attaching clean Evaluation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EvaluationDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EvaluationDAO) ctx.getBean("EvaluationDAO");
	}
	
	/**
	 * 查找所有服务的最大用户平均评分
	 * @return
	 */
	public Double findMaxAvgEvaluation(){
		String hql="select avg(evaluationMark) from Evaluation group by evaluationService";
		List<Double> list = (List<Double>) getHibernateTemplate().find(hql);
		int num = list.size();
		if(num == 0){
			return 0.0;
		}
		else{
			Double maxAvg = 0.0;
			for(int i = 0 ; i < num; i++){
				if(list.get(i) > maxAvg){
					maxAvg = list.get(i);
				}
			}
			return maxAvg;
		}
	}
	
	/**
	 * 查找所有服务的最小用户平均评分
	 * @return
	 */
	public Double findMinAvgEvaluation(){
		String hql="select avg(evaluationMark) from Evaluation group by evaluationService";
		List<Double> list = (List<Double>) getHibernateTemplate().find(hql);
		int num = list.size();
		if(num == 0){
			return 0.0;
		}
		else{
			Double minAvg = list.get(0);
			for(int i = 1; i < num; i++){
				if(list.get(i) < minAvg){
					minAvg = list.get(i);
				}
			}
			return minAvg;
		}
	}
}