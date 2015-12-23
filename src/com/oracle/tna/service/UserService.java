package com.oracle.tna.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.tna.dao.UserDAO;
import com.oracle.tna.domain.User;
import com.oracle.tna.exception.LoginException;
import com.oracle.tna.exception.UserException;

@Service
@Scope("singleton")
public class UserService {

	@Resource
	private UserDAO userDAO;

	public List<User> getAllUsers() throws UserException {
		List<User> users = null;
		try {
			users = userDAO.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
		
	}
	@Transactional(rollbackFor = UserException.class)
	public User createUser(String username, String password, String name,
			String idnum, String tel) throws UserException {
		User user = new User(username, password, name, idnum, tel);
		userDAO.insert(user);
		return user;
	}
	
	public User userLogin(String username, String password)
			throws LoginException {

		return userDAO.retrieve(username, password);
	}
	
	public User searchUser(String username){
		User user = null;
		user = userDAO.search(username);
		return user;
	}
	
	public void updateUser(User user) throws UserException{
		 userDAO.update(user);
	}

}
