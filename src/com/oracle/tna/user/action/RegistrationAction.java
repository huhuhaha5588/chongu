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

@Namespace("/")
@ParentPackage("struts-default")
@Action("Registration")
@Controller
@Scope("prototype")
@Results({
	@Result(name="success",type="redirect" ,location="/user/LoginUser.jsp"),
	@Result(name="input",location="/Registration.jsp")
})
public class RegistrationAction extends ActionSupport  {

	private static final long serialVersionUID = 8118982681597378929L;
	private String username;
	private String password;
	private String repassword;
	private String name;
	private String idnum;
	private String tel;

	@Resource
	private UserService userService;

	@RequiredStringValidator(
		key="error.usernameField.required",
		trim=true
	)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@RequiredStringValidator(
			key="error.passwordField.required",
			trim=true
			//shortCircuit=true
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
		return password;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	
	@RequiredStringValidator(
			key="error.nameField.required",
			trim=true
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
	public String execute() {	
		User user = null;
		if(!(userService.searchUser(username)==null)){
			addActionError(getText("error.username.created"));
			return INPUT ;
		}
		if(password.equals(repassword)){
			try {				
				user = userService.createUser(username, password, name, idnum,tel);
				ActionContext context = ActionContext.getContext();
				HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				return SUCCESS;
			} catch (UserException e) {
				addActionError(getText("error.user.created", new String[]{e.getMessage()}));
				return INPUT;
			}			
		}else{	
			return INPUT;
			}
	}
}













