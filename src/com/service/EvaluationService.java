package com.service;

import java.util.List;

import com.bean.Evaluation;
import com.bean.EvaluationDAO;



public class EvaluationService
{
	EvaluationDAO evaluationDao;

	public EvaluationDAO getEvaluationDao() {
		return evaluationDao;
	}

	public void setEvaluationDao(EvaluationDAO evaluationDao) {
		this.evaluationDao = evaluationDao;
	}

	public void addEvaluatuion(Evaluation e)
	{
		this.evaluationDao.save(e);
	}
	
	public List<Evaluation> getAllEvaluatuion()
	{
		return this.evaluationDao.findAll();
	}
	
	public List<Evaluation> getMyEvaluate(int userid)
	{
		return this.evaluationDao.findByEvaluationUser(userid);
	}
	
	public List<Evaluation> getServiceEvaluate(int sid)
	{
		return this.evaluationDao.findByEvaluationService(sid);
	}
	
	/**
	 * 获取指定服务的用户平均评分
	 * @param serviceid
	 * @return
	 */
	public Double getAvgEvaluation(int serviceid){
		List<Evaluation> evas = getServiceEvaluate(serviceid);
		int num = evas.size();
		if(num == 0){
			return 0.0;
		}
		int points = 0;
		for(int i = 0 ; i < num; i++){
			points += evas.get(i).getEvaluationMark();
		}
		return points * 1.0 / num;
	}
	
	/**
	 * 获取指定服务的最大用户平均评分
	 * @return
	 */
	public Double getMaxAvgEvaluation(){
		return evaluationDao.findMaxAvgEvaluation();
	}
	
	/**
	 * 获取指定服务的最小用户平均评分
	 * @return
	 */
	public Double getMinAvgEvaluation(){
		return evaluationDao.findMinAvgEvaluation();
	}
}