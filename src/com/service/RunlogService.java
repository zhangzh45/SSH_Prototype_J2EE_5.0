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
	
	/**
	 * 获取指定服务的运行次数
	 * @param serviceid
	 * @return
	 */
	/*public int getServiceRuntimes(Integer serviceid){
		List<Runlog> list1 = runlogDao.findByServiceid(serviceid);
		return list1.size();
	}*/
	
	/**
	 * 获取指定服务的运行成功率
	 * @param serviceid
	 * @return
	 */
	/*public double getServiceSuccessRate(Integer serviceid){
		List<Runlog> list1 = runlogDao.findByServiceid(serviceid);
		List<Runlog> list2 = runlogDao.findByRunstate("success");
		int runtimes = list1.size();
		if(runtimes == 0) return 0;
		list1.retainAll(list2); //交集
		int successtimes = list1.size();
		return (double)successtimes/runtimes;
	}*/
	
	/**
	 * 获取指定服务的当前负载
	 * 服务运行记录为running状态
	 * @param serviceid
	 * @return
	 */
	public int getServiceCurrentLoad(int serviceid){
		List<Runlog> list1 = runlogDao.findByServiceid(serviceid);
		List<Runlog> list2 = runlogDao.findByRunstate("running");
		int loadNum = 0;
		list1.retainAll(list2); //交集
		loadNum = list1.size();
		return loadNum;
	}
}