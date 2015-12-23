package com.oracle.tna.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.oracle.tna.domain.AdminUser;
import com.oracle.tna.exception.AdminUserLoginException;

@Repository
@Scope("singleton")
public class AdminDAO {

	private static final String ERROR = "数据库错误";
	private static final String RETRIEVE_ADMIN = "from AdminUser au where au.adminUserName=? and au.password=?";
	@Resource
	private HibernateTemplate hibernateTemplate;

	public AdminDAO() {}

	public AdminUser retrieve(String adminUserName, String password)
			throws AdminUserLoginException {
		AdminUser adminUser = null;
		try {
			List<?> list = this.hibernateTemplate.find(RETRIEVE_ADMIN,
					new Object[] { adminUserName, password });

			if (list.size() == 0)
				throw new AdminUserLoginException("没有找到该用户");
			
			if (list.size() > 1)
				throw new AdminUserLoginException("有重复记录");
			
			adminUser = (AdminUser)list.get(0);
			return adminUser;

		} catch (Exception e) {
			/*e.printStackTrace();*/
			throw new AdminUserLoginException(ERROR + e.getMessage());
		}
	}
}
