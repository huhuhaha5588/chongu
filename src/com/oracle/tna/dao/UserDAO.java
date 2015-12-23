package com.oracle.tna.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;








import com.oracle.tna.domain.User;
import com.oracle.tna.exception.LoginException;
import com.oracle.tna.exception.UserException;

@Repository
public class UserDAO {

	@Resource
	private HibernateTemplate hibernateTemplate;
	private static String SELECT_ALL = "from User";
	private static String UID_USER = "from User u where u.uid = ?";
	
	private static final String RETRIEVE_USER = "select u from User u where u.username=? and u.password=?";
	private static final String SEARCH_USER = "select u from User u where u.username=?";
	private static final String ERROR = "数据库错误";
	
	
	public UserDAO(){
		
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() throws UserException{
		List<User> users = null;
		try {
			users = hibernateTemplate.find(SELECT_ALL);
			
		} catch (Exception e) {
			throw new UserException(e);
		}
		return users;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUser(int uid) throws UserException {
		List<User> users = null;
		try {
			users = hibernateTemplate.find(UID_USER,new Object[]{uid});
			
		} catch (Exception e) {
			throw new UserException(e);
		}
		return users;
	}
	
	
	
	public void insert(User user) throws UserException {

		try {
			this.hibernateTemplate.save(user);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new UserException(ex);
		}
	}

	public User retrieve(String username, String password)
			throws LoginException {
		try {
			List<?> list = this.hibernateTemplate.find(RETRIEVE_USER,
					new Object[] { username, password });
			if (list.size() == 0)
				throw new LoginException("û���ҵ����û�");
			if (list.size() > 1) {
				throw new LoginException("���ظ���¼");
			}

			return (User) list.get(0);

		} catch (Exception e) {
			throw new LoginException(ERROR + e.getMessage());
		}
	}
	
	public User search(String username){
		User user = null;
		try {
			List<?> list = this.hibernateTemplate.find(SEARCH_USER,
					new Object[] {username});
			if (list.size() == 0){
			}else{
				user = (User)list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public void update(User user) throws UserException{
		try {
			this.hibernateTemplate.update(user);
		} catch (Exception ex) {
			throw new UserException(ex);
		}
	}
	
	
	
}
