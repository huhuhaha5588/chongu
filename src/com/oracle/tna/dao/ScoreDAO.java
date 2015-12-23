package com.oracle.tna.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.oracle.tna.domain.Score;
import com.oracle.tna.exception.ExamException;
import com.oracle.tna.exception.ScoreException;

@Repository
public class ScoreDAO {

	
	public static String SELECT_ALL = "FROM Score";
	public static String UID_SCORE = "FROM Score s where s.uid = ?";
	private static final String GET_SCORE = "FROM Score s WHERE s.sid=?";
	private static final String GET_SCORE_BY_ID = "FROM Score s WHERE s.uid=?";
	private List<Score> scores;
	@Resource
	public HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Score> getAllScores() throws ScoreException{
		List<Score> scores = null;
		try {
			scores = hibernateTemplate.find(SELECT_ALL);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scores;
	}
	@SuppressWarnings("unchecked")
	public List<Score> getScores(int uid) throws ScoreException{
		List<Score> scores = null;
		try {
			
			scores = hibernateTemplate.find(UID_SCORE, new Object[] {uid});
			
		} catch (Exception e) {
			throw new ScoreException(e);
		}
		return scores;
	}
	
	
	@SuppressWarnings("unchecked")
	public Score getScore(int sid) throws ScoreException{
		scores = new ArrayList<Score>();
		try {
			scores = hibernateTemplate.find(GET_SCORE, new Object[]{sid});
		} catch (Exception e) {
			throw new ScoreException(e);
		}
		return scores.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Score> getScoresByUid(int uid) throws ScoreException{
		scores = new ArrayList<Score>();
		try {
			scores = hibernateTemplate.find(GET_SCORE_BY_ID, new Object[]{uid});
		} catch (Exception e) {
			throw new ScoreException(e);
		}
		return scores;
	}
	
	public void insertScore(Score score) throws ExamException{
		try {
			hibernateTemplate.save(score);
		} catch (Exception e) {
			throw new ExamException(e);
		}
	}
	
	
}
