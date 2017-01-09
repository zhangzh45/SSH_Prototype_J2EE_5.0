package com.service;

import java.util.List;

import com.bean.Runlog;
import com.bean.RunlogDAO;

public class RunlogService
{
	private RunlogDAO runlogDao;

	public RunlogDAO getRunlogDao() {
		return runlogDao;
	}
	public void setRunlogDao(RunlogDAO runlogDao) {
		this.runlogDao = runlogDao;
	}
	public void addRunlog(Runlog rl)
	{
		this.runlogDao.save(rl);
	}
	public void update(Runlog rl)
	{
		this.runlogDao.attachDirty(rl);
	}
	public List<Runlog> getAllRunlog()
	{
		return this.runlogDao.findAll();
	}
	public void deleteRunlog(Runlog rl)
	{
		this.runlogDao.delete(rl);
	}
	public Runlog getUniqueRunlog(Integer id)
	{
		//System.out.println(Integer.valueOf(id));
		return this.runlogDao.findById(id);
	}
	
	public int getRunlogNum()
	{
		return this.getAllRunlog().size();
	}
	
	public List findByServiceid(Integer serviceid){
		return runlogDao.findByServiceid(serviceid);
	}
	
	public List findByUserid(Integer userid){
		return runlogDao.findByUserid(userid);
	}
	
	public List findByRunstate(String runstate){
		return runlogDao.findByRunstate(runstate);
	}
}