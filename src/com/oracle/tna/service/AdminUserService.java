package com.oracle.tna.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.tna.dao.AdminDAO;
import com.oracle.tna.domain.AdminUser;
import com.oracle.tna.exception.AdminUserException;

@Service
@Scope("singleton")
public class AdminUserService {
	
	@Resource
    public AdminDAO adminDAO;
    
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
    public AdminUser adminUserLogin(String adminUserName, String password) 
            throws AdminUserException{
        return adminDAO.retrieve(adminUserName, password);
    }
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
    public List<AdminUser> getAllAdminUser() 
            throws AdminUserException{
        return adminDAO.getAllAdminUsers();
    }
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
    public AdminUser find(String adminUsername) 
            throws AdminUserException{
        return adminDAO.find(adminUsername);
    }
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
    public List<AdminUser> search(String adminUsername) 
            throws AdminUserException{
        return adminDAO.search(adminUsername);
    }
	
	public static void main(String[] argS){
		AdminUserService adminUserService = new AdminUserService();
		try {
			List<AdminUser> admins = adminUserService.getAllAdminUser();
			System.out.println(admins.toString());
		} catch (AdminUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

