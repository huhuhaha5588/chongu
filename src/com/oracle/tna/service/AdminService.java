package com.oracle.tna.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.tna.dao.AdminDAO;
import com.oracle.tna.domain.AdminUser;
import com.oracle.tna.exception.AdminUserLoginException;

@Service
@Scope("singleton")
public class AdminService {
	
	@Resource
    public AdminDAO adminDAO;
    
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
    public AdminUser adminUserLogin(String adminUserName, String password) 
            throws AdminUserLoginException{
        return adminDAO.retrieve(adminUserName, password);
    }
}

