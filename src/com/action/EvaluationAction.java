package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Evaluation;
import com.bean.Service;
import com.opensymphony.xwork2.ActionSupport;
import com.service.EvaluationService;
import com.service.SerService;
import com.util.ServiceQuality;


public class EvaluationAction extends ActionSupport
{
	private EvaluationService evaluationsr = new EvaluationService();
	private SerService srs = new SerService();
	Evaluation e = new Evaluation();
	String option1;
	String option2;
	String option3;
	
	List<Service> services = new ArrayList<Service>();
	List<Service> allservices = new ArrayList<Service>();
	List<Evaluation> alle = new ArrayList<Evaluation>();
	List<Evaluation> allall = new ArrayList<Evaluation>();
	
	List<ServiceQuality> sqs = new ArrayList<ServiceQuality>();
	
	ArrayList<Double> score = new ArrayList<Double>();
	ArrayList<Integer> num = new ArrayList<Integer>();
	
	public static double maxScore = 5.0;
	
	public List<ServiceQuality> getSqs() {
		return sqs;
	}

	public void setSqs(List<ServiceQuality> sqs) {
		this.sqs = sqs;
	}

	public static double getMaxScore() {
		return maxScore;
	}

	public static void setMaxScore(double maxScore) {
		EvaluationAction.maxScore = maxScore;
	}

	public ArrayList<Double> getScore() {
		return score;
	}

	public void setScore(ArrayList<Double> score) {
		this.score = score;
	}

	public ArrayList<Integer> getNum() {
		return num;
	}

	public void setNum(ArrayList<Integer> num) {
		this.num = num;
	}

	public List<Evaluation> getAllall() {
		return allall;
	}

	public void setAllall(List<Evaluation> allall) {
		this.allall = allall;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public EvaluationService getEvaluationsr() {
		return evaluationsr;
	}

	public void setEvaluationsr(EvaluationService evaluationsr) {
		this.evaluationsr = evaluationsr;
	}

	public Evaluation getE() {
		return e;
	}

	public void setE(Evaluation e) {
		this.e = e;
	}

	public SerService getSrs() {
		return srs;
	}

	public void setSrs(SerService srs) {
		this.srs = srs;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Service> getAllservices() {
		return allservices;
	}

	public void setAllservices(List<Service> allservices) {
		this.allservices = allservices;
	}

	public List<Evaluation> getAlle() {
		return alle;
	}

	public void setAlle(List<Evaluation> alle) {
		this.alle = alle;
	}
	
	public String quality()
	{
		try
		{
			sqs.clear();
			allservices = srs.getAllService();
			//alle = evaluationsr.getAllEvaluatuion();
			
			for(int i = 0; i < allservices.size(); i++)
			{
				ServiceQuality sq = new ServiceQuality();
				sq.setServiceId(allservices.get(i).getServiceId());
				sq.setRunTime(allservices.get(i).getRunTimes());
				if(allservices.get(i).getRunTimes() == 0)
				{
					continue;
				}
				sq.setFailTime(allservices.get(i).getFailTimes());
				double qos = (allservices.get(i).getRunTimes() - allservices.get(i).getFailTimes()) * 1.0 / allservices.get(i).getRunTimes();
				sq.setQos(qos);
				alle = evaluationsr.getServiceEvaluate(allservices.get(i).getServiceId());
				double sum = 0;
				int num = alle.size();
				if(num == 0)
				{
					continue;
				}
				for(int j = 0; j < num; j++)
				{
					sum = sum + Integer.parseInt(alle.get(j).getEvaluationMark());
				}
				double avg = sum / num / maxScore;
				sq.setEvaluationNumber(num);
				sq.setAvg(avg);
				sq.setF(2 * qos * avg / (qos + avg));
				sqs.add(sq);
			}
			System.out.print(sqs.size());
			
			return SUCCESS;
		}
		catch(Exception e)
		{
			return ERROR;
		}
	}

	public String getUnEvaluateNotSave()
	{
		try
		{
			services.clear();
			allservices = srs.getAcceptedService();
			alle = evaluationsr.getAllEvaluatuion();
			for(int i = 0; i < allservices.size(); i++)
			{
				int flag = 1;
				for(int j = 0; j < alle.size(); j++)
				{
					if(allservices.get(i).getServiceId().equals(alle.get(j).getEvaluationService()) 
					&& alle.get(j).getEvaluationUser().equals(Integer.valueOf(option3))
					)
					{
						flag = 0;
						break;
					}
				}
				if(flag == 1)
				{
					services.add(allservices.get(i));
				}
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String getUnEvaluate()
	{
		try
		{
			services.clear();
			System.out.println(option2);
			e.setEvaluationMark(option2);
			e.setEvaluationService(Integer.valueOf(option1));
			e.setEvaluationUser(Integer.valueOf(option3));
			this.evaluationsr.addEvaluatuion(e);
			allservices = srs.getAcceptedService();
			alle = evaluationsr.getAllEvaluatuion();
			for(int i = 0; i < allservices.size(); i++)
			{
				int flag = 1;
				for(int j = 0; j < alle.size(); j++)
				{
					if(allservices.get(i).getServiceId().equals(alle.get(j).getEvaluationService()) 
					&& alle.get(j).getEvaluationUser().equals(Integer.valueOf(option3))
					)
					{
						flag = 0;
						break;
					}
				}
				if(flag == 1)
				{
					services.add(allservices.get(i));
				}
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String getMyEvaluate()
	{
		try
		{
			score.clear();
			num.clear();
			alle = this.evaluationsr.getMyEvaluate(Integer.valueOf(option3));

			for(int i = 0; i < alle.size(); i++)
			{
				score.add(0.0);
				num.add(0);
			}
			allall = this.evaluationsr.getAllEvaluatuion();
			for(int i = 0; i < allall.size(); i++)
			{
				for(int j = 0; j < alle.size(); j++)
				{
					if(allall.get(i).getEvaluationService().equals(alle.get(j).getEvaluationService()))
					{
						score.set(j, score.get(j) + Integer.valueOf(allall.get(i).getEvaluationMark()));
						num.set(j, num.get(j) + 1);
					}
				}
			}
			for(int i = 0; i < score.size(); i++)
			{
				score.set(i, score.get(i) / num.get(i));
			}
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
}