package com.oracle.tna.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.oracle.tna.dao.ItemDAO;
import com.oracle.tna.dao.ScoreDAO;
import com.oracle.tna.domain.Item;
import com.oracle.tna.domain.Score;
import com.oracle.tna.exception.ExamException;

@Service
@Scope
public class ExamService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2348269731343213952L;
	@Resource
	private ItemDAO itemDAO;
	@Resource
	private ScoreDAO scoreDAO;
	private List<Item> items;
	private int item_number = 10;
	
	private String[] selects = {"A","B","C","D"};
	public String[] getSelects() {
		return selects;
	}

	//随机生成试题卷
	public List<Item> getItems() throws ExamException{      
		Long item_database_length = itemDAO.getCount();     //数据库中数据不够的时候用来做测试的
		if(item_database_length < item_number){
			items = itemDAO.getItems();
			return items;
		}
		items = new ArrayList<Item>();
		
		Random rand = new Random();
		int maxId = itemDAO.getMaxId();
		int minId = itemDAO.getMinId();
		for(int i=0;i<item_number;i++){
			Item item = null;
			try {
				int ra = rand.nextInt(maxId) + minId;
				item = itemDAO.getItem(ra); 			 //找不到相应的题，就退回一步，并抛出异常
			} catch (Exception e) {
				i -= 1;
				continue;
			}
			
			Boolean flag = true;
			for(Item it:items){
				if(it.getQid() == item.getQid()){        //找到了重复的题也退回一步
					i -= 1;
					flag = false;
					break;
				}
			}
			if(flag) items.add(item);	
		}
		return items;
	}
	
	public void saveScore(Score score) throws ExamException{
		scoreDAO.insertScore(score);
	}
	
	//�з�
	public Score createScore(List<Item> items, String[] answers, int uid) throws ExamException{
		int score = 0;
		try {
			for(int i=0;i<items.size();i++){
				if(answers[i].equals(items.get(i).getAnswer())) score += 10;
			}
		} catch (Exception e) {
			throw new ExamException(e);
		}
		
		String answer = answers[0];
		for(int i=1;i<answers.length;i++){
			answer += "," + answers[i];
		}
		
		String s_answer = items.get(0).getAnswer();
		for(int i=1;i<items.size();i++){
			s_answer += "," + items.get(i).getAnswer();
		}
		
		return new Score(uid, score, answer, s_answer);
	}
	
	
}
