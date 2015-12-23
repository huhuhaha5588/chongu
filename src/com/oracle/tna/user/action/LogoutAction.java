
		package com.oracle.tna.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;



import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.tna.web.LoginFilter;


@Namespace("/user")
@ParentPackage("struts-default")
@Action("Logout")
@Result(name="success", location="/user/LoginUser.jsp")
public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = -6195197664489521715L;
    @Override
	public String execute(){
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		session.setAttribute(LoginFilter.ATTR_USER, null);//将Session中保存的user信息 销毁
	 return SUCCESS;
	}
		
		
		
}
