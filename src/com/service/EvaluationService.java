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
	
	
}