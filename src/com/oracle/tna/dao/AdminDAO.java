package com.oracle.tna.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.oracle.tna.domain.AdminUser;
import com.oracle.tna.domain.User;
import com.oracle.tna.exception.AdminUserException;
import com.oracle.tna.exception.UserException;

@Repository
@Scope("singleton")
public class AdminDAO {

	private static final String ERROR = "数据库错误";
	private static final String RETRIEVE_ADMIN = "from AdminUser au where au.adminUserName=? and au.password=?";
	private static final String SEARCH_ADMIN = "select au from User au where au.adminUserName=?";
	private static final String SELECT_ALL = "from AdminUser";	
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public AdminDAO() {}

	public AdminUser retrieve(String adminUserName, String password)
			throws AdminUserException {
		AdminUser adminUser = null;
		try {
			List<?> list = this.hibernateTemplate.find(RETRIEVE_ADMIN,
					new Object[] { adminUserName, password });

			if (list.size() == 0)
				throw new AdminUserException("没有找到该用户");
			
			if (list.size() > 1)
				throw new AdminUserException("有重复记录");
			
			adminUser = (AdminUser)list.get(0);
			return adminUser;

		} catch (Exception e) {
			/*e.printStackTrace();*/
			throw new AdminUserException(ERROR + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AdminUser> getAllAdminUsers() throws AdminUserException{
		List<AdminUser> adminUsers = null;
		try {
			adminUsers = hibernateTemplate.find(SELECT_ALL);
		} catch (Exception e) {
			throw new AdminUserException(e);
		}
		return adminUsers;
	}
	
	public void update(AdminUser adminUser) throws AdminUserException{
		try {
			this.hibernateTemplate.update(adminUser);
		} catch (Exception ex) {
			throw new AdminUserException(ex);
		}
	}
	
	public AdminUser search(String adminUsername){
		AdminUser adminUser = null;
		try {
			List<?> list = this.hibernateTemplate.find(SEARCH_ADMIN,
					new Object[] {adminUsername});
			if (list.size() == 0){
			}else{
				adminUser = (AdminUser)list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminUser;
	}
	
	public void insert(AdminUser adminUser) throws AdminUserException {

		try {
			this.hibernateTemplate.save(adminUser);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new AdminUserException(ex);
		}
	}
}
