package com.oracle.tna.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.oracle.tna.domain.Item;
import com.oracle.tna.exception.ExamException;
import com.oracle.tna.exception.TNAException;

@Repository
@Scope
public class ItemDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3164258266302263914L;
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	private static final String SELECT_ALL = "from Item";
	private static final String FIND = "from Item where qid=?";
	private static final String ERROR = "��ݿ����";
	
	private List<Item> items ;
	/*private long count;*/
	
	//HQL
	private static final String GET_ITEM = "FROM Item i WHERE i.qid=?";
	private static final String GET_ITEMS = "FROM Item";
	private static final String GET_COUNT = "SELECT COUNT(i) FROM Item i";	
	private static final String GET_MAX_ID = "SELECT MAX(qid) FROM Item i";
	private static final String GET_MIN_ID = "SELECT MIN(qid) FROM Item i";	
	
	public ItemDAO() {}
	
	@SuppressWarnings("unchecked")
	public Long getCount() throws ExamException{      
		List<Long> counts = null;
		try {
			counts = hibernateTemplate.find(GET_COUNT);
		} catch (Exception e) {
			throw new ExamException(e);
		}
		return counts.get(0);
	}

	@SuppressWarnings("unchecked")
	public Item getItem(int qid) throws ExamException{
		try {
			items = hibernateTemplate.find(GET_ITEM, new Object[]{qid});
		} catch (Exception e) {
			throw new ExamException(e);
		}
		return items.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> getItems() throws ExamException{	
		try {
			items = hibernateTemplate.find(GET_ITEMS);
		} catch (Exception e) {
			throw new ExamException(e);
		}
		return items;
	}
	/*�������*/
	@SuppressWarnings("unchecked")
	public List<Item> showAllItems() throws TNAException
	{
		List<Item> list = new ArrayList<Item>();
		try {
			list = this.hibernateTemplate.find(SELECT_ALL);
		}
		catch (Exception e) {
			throw new TNAException(e.getMessage()+ERROR);	
		}
		return list;
	}
	
	public Item findItem(int qid) throws TNAException
	{
		Item item = null;
		try {
			@SuppressWarnings("unchecked")
			List<Item> list = this.hibernateTemplate.find(FIND,new Object[]{qid});
			item = (Item)list.get(0);
		} catch (Exception e) {
			throw new TNAException(e.getMessage()+ERROR);
		}
		
		return item;
	}
	
	public void DeleteItem(Item item) throws TNAException
	{
		try {
			this.hibernateTemplate.delete(item);
		} catch (Exception e) {
			throw new TNAException(e.getMessage()+ERROR);
		}
	}
	
	public void UpdateItem(Item item) throws TNAException
	{
		try {
			this.hibernateTemplate.update(item);
		} catch (Exception e) {
			throw new TNAException(e.getMessage()+ERROR);
		}
	}
	
	public void AddItem(Item item) throws TNAException
	{
		try {
			this.hibernateTemplate.save(item);
		} catch (Exception e) {
			throw new TNAException(e.getMessage()+ERROR);
		}
	}
	
	//得到题库qid的上限
	@SuppressWarnings("unchecked")
	public int getMaxId() throws ExamException{
		List<Integer> maxId = null;
		try {
			maxId = hibernateTemplate.find(GET_MAX_ID);
		} catch (Exception e) {
			throw new ExamException(e);
		}
		return maxId.get(0);
	}
	
	//得到题库qid的下限
	@SuppressWarnings("unchecked")
	public int getMinId() throws ExamException{
		List<Integer> minId = null;
		try {
			minId = hibernateTemplate.find(GET_MIN_ID);
		} catch (Exception e) {
			throw new ExamException(e);
		}
		return minId.get(0);
	}
}
