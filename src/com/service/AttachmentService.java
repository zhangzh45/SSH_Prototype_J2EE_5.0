package com.service;

import java.util.List;

import com.bean.Attachment;
import com.bean.AttachmentDAO;

public class AttachmentService
{
	private AttachmentDAO attachmentDao;


	public AttachmentDAO getAttachmentDao() {
		return attachmentDao;
	}
	public void setAttachmentDao(AttachmentDAO attachmentDao) {
		this.attachmentDao = attachmentDao;
	}
	
	public void addAttachment(Attachment a)
	{
		this.attachmentDao.save(a);
	}
	
	public void update(Attachment a)
	{
		this.attachmentDao.attachDirty(a);
	}
	
	public List<Attachment> getAllAttachment()
	{
		return this.attachmentDao.findAll();
	}
	
	public void deleteAttachment(Attachment a)
	{
		this.attachmentDao.delete(a);
	}
	
	public Attachment getUniqueAttachment(Integer id)
	{
		//System.out.println(Integer.valueOf(id));
		return this.attachmentDao.findById(id);
	}
	
	public int getAttachmentNum()
	{
		return this.getAllAttachment().size();
	}
	
	
	public List findByFilepath(String filepath){
		return attachmentDao.findByFilepath(filepath);
	}
	
}