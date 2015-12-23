/*package com.bjoracle.cms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.bjoracle.cms.domain.Adminuser;
import com.bjoracle.cms.exception.LoginException;
import com.bjoracle.cms.service.LoginService;
import com.bjoracle.cms.web.LoginFilter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/admin")
@ParentPackage(value="struts-default")
@Action(value="Login")
@Results({
	@Result(name="success",type="redirect",location="${forwardUrl}"),
	@Result(name="input",location="/admin/Login.jsp")
	
})
public class AdminLoginAction extends ActionSupport {

	private static final long serialVersionUID = 2839575927490202176L;
	
	private String forwardUrl;
	private String username;
	private String password;
	
	
	
	public AdminLoginAction() {
		super();
	}



	public AdminLoginAction(String forwardUrl, String username, String password) {
		super();
		this.forwardUrl = forwardUrl;
		this.username = username;
		this.password = password;
	}



	public String getForwardUrl() {
		return forwardUrl;
	}



	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String execute(){
		LoginService loginSvcLoginService = LoginService.getInstance();
		
		Adminuser admin = null;
		try{
			admin = loginSvcLoginService.adminLogin(username, password);
		}catch(LoginException e){
			
			addActionError(getText("error.login.failure",new String[]{e.getMessage()}));
			return INPUT;
		}
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		
		HttpSession session=request.getSession();
		session.setAttribute(LoginFilter.ATTR_ADMINUSER,admin);
		
		forwardUrl = (String)session.getAttribute(LoginFilter.ATTR_NEXTURL);
		
		if(forwardUrl==null)forwardUrl="/";
		
		return SUCCESS;
		
	}

}*/
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



import com.oracle.tna.domain.User;
import com.oracle.tna.exception.LoginException;
import com.oracle.tna.service.UserService;
import com.oracle.tna.web.LoginFilter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;



@Namespace(value="/user")
@ParentPackage(value="struts-default")
@Action("Login")
@Controller
@Scope("prototype")
@Results({  
   @Result(name="success", type="redirect", location="${forwardUrl}"), 
   @Result(name="input", location="/user/LoginUser.jsp") 
})
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -5983591562423935190L;
	private String forwardUrl;
    private String username;
    private String password;

    @Resource
    private UserService userService;
    public String getForwardUrl() {
        return forwardUrl;
    }

    @RequiredStringValidator(
        type = ValidatorType.FIELD,
        key = "error.login.username.required",
        trim = true
    )
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @RequiredStringValidator(
        type = ValidatorType.FIELD,
        key = "error.login.password.required",
        trim = true
    )
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() {
      
       User user = null;
        try {
        	user = userService.userLogin(username, password);
        } catch (LoginException e) {
            this.addActionError(
                    getText("error.login.failure"));
            return INPUT;
        }
        
        ActionContext ctx = ActionContext.getContext(); 
        HttpServletRequest request = 
                (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);  
        HttpSession session = request.getSession();
        session.setAttribute(LoginFilter.ATTR_USER, user);  
        forwardUrl = (String)session.getAttribute(LoginFilter.ATTR_NEXTURL);
        if (forwardUrl == null) forwardUrl = "index.jsp";     //when session timeout
 
        return SUCCESS;
    }
   
}

