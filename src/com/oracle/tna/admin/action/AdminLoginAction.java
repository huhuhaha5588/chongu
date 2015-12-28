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
@Action(value = "AdminLogin")
@Controller
@Results({
	@Result(name = "success", type = "redirect", location = "${forwardUrl}"),
	@Result(name = "input", location = "/admin/AdminLogin.jsp") })
public class AdminLoginAction extends ActionSupport {
	private static final long serialVersionUID = -5983591562423935190L;
	private String forwardUrl;
	private String adminUserName;
	private String password;

	@Resource
	private AdminUserService adminService;

	public String getForwardUrl() {
		return forwardUrl;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, key = "error.login.username.required", trim = true)
	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, key = "error.login.password.required", trim = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		session.setAttribute(AdminLoginFilter.ATTR_ADMINUSER, admin);

		forwardUrl = (String) session.getAttribute(AdminLoginFilter.ATTR_NEXTURL);
		if (forwardUrl == null)
			forwardUrl = "index.jsp"; // when session timeout

		return SUCCESS;
	}
}
