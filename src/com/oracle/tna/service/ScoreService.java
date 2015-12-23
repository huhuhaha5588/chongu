package com.oracle.tna.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.tna.dao.ScoreDAO;
import com.oracle.tna.dao.UserDAO;
import com.oracle.tna.domain.Score;
import com.oracle.tna.domain.User;
import com.oracle.tna.domain.UserScore;
import com.oracle.tna.exception.ScoreException;


@Service
@Scope("singleton")
public class ScoreService {

	@Resource
	private ScoreDAO scoreDAO;
	@Resource
	private UserDAO userDAO;
	
	private List<Score> scores;
	
	@Transactional(rollbackFor = Exception.class)
	public List<UserScore> getAllScores() throws ScoreException {
		List<Score> scores = null;
		List<User> users = null;
		List<UserScore> userScores = null;
		try {
			//����ScoreDAO,ȡ���з�װ�˿��Լ�¼��Ϣ��Score����
			scores = scoreDAO.getAllScores();
			userScores = new ArrayList<UserScore>();
			for(Score s:scores){
				//����UserDAO���Ի�ȡ���з�װ���û���Ϣ��User����
				users = userDAO.getUser(s.getUid());
				for(User u:users){
					//��Score��User������װΪ�µ�UserScore����
					userScores.add(new UserScore(u, s));
				}
			}
		} catch (Exception e) {
			throw new ScoreException();
		}
		return userScores;
		
	}
	public List<Score> getIdScores(int uid) throws ScoreException{
		List<Score> scores = null;
		try {
			scores = scoreDAO.getScores(uid);
		} catch (Exception e) {
			throw new ScoreException(e);
		}
		return scores;
	}
	public List<Score> getScoresByUid(int uid) throws ScoreException{
		scores = scoreDAO.getScoresByUid(uid);
		return scores;
	}
	
	public Score getScore(int sid) throws ScoreException{
		Score score = scoreDAO.getScore(sid);
		return score;
	}
}
