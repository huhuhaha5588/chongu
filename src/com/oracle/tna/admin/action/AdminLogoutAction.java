package com.oracle.tna.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.tna.web.AdminLoginFilter;

@Namespace(value = "/admin")
@ParentPackage(value = "struts-default")
@Action(value = "AdminLogout")
@Controller
@Result(name="success",location = "/admin/AdminLogin.jsp")
public class AdminLogoutAction extends ActionSupport{

	private static final long serialVersionUID = 1693917081459198027L;
	
	@Override
	public String execute() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		session.setAttribute(AdminLoginFilter.ATTR_ADMINUSER,null);
		return SUCCESS;
	}
}
