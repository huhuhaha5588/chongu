package com.oracle.tna.user.action;

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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.tna.domain.Item;
import com.oracle.tna.domain.Score;
import com.oracle.tna.domain.User;
import com.oracle.tna.exception.ExamException;
import com.oracle.tna.service.ExamService;
import com.oracle.tna.web.LoginFilter;

@Namespace("/user")
@ParentPackage("struts-default")
@Action("Exam")
@Controller
@Scope("prototype")
@Results({
	@Result(name="success", location="/user/ShowScore.jsp"),
	@Result(name="input", type="redirect", location="/user/Exam.jsp")
})	
public class ExamAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2243451919936704040L;
	@Resource
	private ExamService examService;

	private String answer0;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
	private String answer6;
	private String answer7;
	private String answer8;
	private String answer9;
	
	public String getAnswer0() {
		return answer0;
	}
	public void setAnswer0(String answer0) {
		this.answer0 = answer0;
	}
	
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	
	
	public String getAnswer5() {
		return answer5;
	}
	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}
	
	public String getAnswer6() {
		return answer6;
	}
	public void setAnswer6(String answer6) {
		this.answer6 = answer6;
	}
	
	public String getAnswer7() {
		return answer7;
	}
	public void setAnswer7(String answer7) {
		this.answer7 = answer7;
	}
	
	public String getAnswer8() {
		return answer8;
	}
	public void setAnswer8(String answer8) {
		this.answer8 = answer8;
	}
	
	public String getAnswer9() {
		return answer9;
	}
	public void setAnswer9(String answer9) {
		this.answer9 = answer9;
	}
	
	
	@Override
	public String execute() throws Exception {
		
		String[] answers = {answer0, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9};
		
		ActionContext ctx = ActionContext.getContext(); 
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);  
        HttpSession session = request.getSession();   //System.out.println("AdminLoginAction��session="+session);
        
        @SuppressWarnings("unchecked")
		List<Item> items = (List<Item>) session.getAttribute("items");
        if(items==null) return INPUT; 
        
        //session.setAttribute("user", new User(1,"wangrunning","123456","wangrunning","12","12"));///////////////
        int uid = ((User)session.getAttribute(LoginFilter.ATTR_USER)).getUid();
        
        Score score = null;
		try {
			score = examService.createScore(items, answers, uid);
		} catch (ExamException e) {
			addActionError(getText("error.actionError"));
			return INPUT;
		}
        request.setAttribute("score", score);
        request.setAttribute("answers", answers); 
    	request.setAttribute("s_answers", score.getS_answers());
        examService.saveScore(score);
        return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
