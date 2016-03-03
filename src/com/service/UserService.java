package com.service;

import java.util.List;

import com.bean.User;
import com.bean.UserDAO;


public class UserService
{
	private UserDAO userDao;

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public User getUniqueUser(int id)
	{
		return (User)this.userDao.findById(id);
	}

	public void addUser(User user)
	{
		this.userDao.save(user);
	}
	
	public List<User> getAllUsers()
	{
		return (List<User>)this.userDao.findAll();
	}
	public void deleteUser(User user)
	{
		this.userDao.delete(user);
	}
	
	public int getUserNum()
	{
		return this.getAllUsers().size();
	}
}