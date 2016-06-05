package com.oracle.tna.admin.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.oracle.tna.domain.AdminUser;
import com.oracle.tna.exception.AdminUserException;
import com.oracle.tna.service.AdminUserService;
import com.oracle.tna.web.AdminLoginFilter;

@Namespace(value = "/admin")
@ParentPackage(value = "struts-default")
@Action(value = "AddAdminUser")
@Controller
@Results({
	@Result(name = "success", type = "redirect", location = "/admin/adminManage/adminUserManage.jsp"),
	@Result(name = "input", location = "/admin/adminManage/adminUserManage.jsp") })
public class AdminUserManageQuery extends ActionSupport {
	private static final long serialVersionUID = -4549122750519148337L;
	//searching factors
	private String adminUserName;
	
	//?adminUserName="+ request.getParameter("adminUserName")

	
	@Resource
	private AdminUserService adminService;



	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}




	@Override
	public String execute() {

		List<AdminUser> admin = null;
		try {
			admin = adminService.search(adminUserName);
		} catch (AdminUserException e) {
			System.out.println("查询出错了");
			//this.addActionError(getText("error.login.failure"));/*,new String[] { e.getMessage() }*/
			return INPUT;
		}

		

		return SUCCESS;
	}
}
