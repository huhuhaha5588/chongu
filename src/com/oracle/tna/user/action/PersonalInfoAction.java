package com.oracle.tna.user.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.oracle.tna.domain.User;
import com.oracle.tna.exception.UserException;
import com.oracle.tna.service.UserService;
import com.oracle.tna.web.LoginFilter;
@Namespace("/user")
@ParentPackage("struts-default")
@Action("PersonalInfo")
@Controller
@Scope("prototype")
@Results({
	@Result(name="success", location="/user/index.jsp"),
	@Result(name="input", location="/user/PersonalInfo.jsp")
})
public class PersonalInfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserService userService;
	
	private String username;
	private String password;
	private String repassword;
	private String name;
	private String idnum;
	private String tel;
	
	public PersonalInfoAction() {
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@RequiredStringValidator(
			key="error.passwordField.required",
			trim=true
		)
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
			key="error.nameField.required"
		)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@RequiredStringValidator(
			key="error.idmunField.required",
			trim=true,
			shortCircuit=true
			)
	@StringLengthFieldValidator(
			key="error.idnumField.range",
			minLength="18",
			maxLength="18"
		)
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	
	@RequiredStringValidator(
			key="error.telField.required",
			trim=true,
			shortCircuit=true
		)
	@StringLengthFieldValidator(
			key="error.telField.range",
			minLength="11",
			maxLength="11"
		)
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String execute() throws Exception {
		if(password.equals(repassword)){
			try {
				ActionContext context = ActionContext.getContext();
				HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute(LoginFilter.ATTR_USER);
				/*user = new User(username, password, name, idnum,tel);*/
				
				user.setPassword(password);
				user.setName(name);
				user.setIdnum(idnum);
				user.setTel(tel);
				userService.updateUser(user);
				
				session.setAttribute(LoginFilter.ATTR_USER,user);
				return SUCCESS;
			} catch (UserException e) {
				addActionError(getText("error.user.update", new String[]{e.getMessage()}));
				return INPUT;
			}
		}else {
			return INPUT;
		}	
		
	}
}
