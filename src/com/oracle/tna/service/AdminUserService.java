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
    public List<AdminUser> showAdminUser() 
            throws AdminUserException{
        return adminDAO.getAllAdminUsers();
    }
	
	
}

