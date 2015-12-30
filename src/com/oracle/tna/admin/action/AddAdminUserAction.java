package com.oracle.tna.admin.action;

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
	@Result(name = "success", type = "redirect", location = "/admin/AddAdminUser.jsp"),
	@Result(name = "input", location = "/admin/AddAdminUser.jsp") })
public class AddAdminUserAction extends ActionSupport {
	private static final long serialVersionUID = -4549122750519148337L;
	private String adminUserName;
	private String password;
	private String repassword;
	private String name;
	private String idnum;
	private String tel;

	
	@Resource
	private AdminUserService adminService;


	@RequiredStringValidator(
			type = ValidatorType.FIELD, 
			key = "error.login.username.required", 
			trim = true)
	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	@RequiredStringValidator(
			type = ValidatorType.FIELD,
			key = "error.login.password.required",
trim = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@RequiredStringValidator(
			key="error.repasswordField.required",
			trim=true
		)
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	@RequiredStringValidator(
			key="error.usernameField.required",
			trim=true
		)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	@Override
	public String execute() {

		AdminUser admin = null;
		try {
			admin = adminService.adminUserLogin(adminUserName, password);
		} catch (AdminUserException e) {
			System.out.println("登录失败的一场抛出");
			this.addActionError(getText("error.login.failure"));/*,new String[] { e.getMessage() }*/
			return INPUT;
		}

		

		return SUCCESS;
	}
}
