package com.oracle.tna.admin.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.oracle.tna.domain.Item;
import com.oracle.tna.exception.TNAException;
import com.oracle.tna.service.ItemService;

@Namespace("/")
@ParentPackage("struts-default")
@Action("addItemAction")
@Controller
@Scope("prototype")
@Results({
	@Result(name="success" , type="redirect", location=("/admin/itemlist.jsp")),
	@Result(name="input" ,type="redirect", location=("/admin/addItem.jsp"))
})
public class AddItemAction extends ActionSupport
{
	private static final long serialVersionUID = -3612225121403972449L;
	@Resource
	private ItemService itemService;
	private int qid;
	private String question;
	private String optiona;
	private String optionb;
	private String optionc;
	private String optiond;
	private String answer;
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	@RequiredStringValidator(
			key="error.question.require",
			trim=true
		)
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@RequiredStringValidator(
			key="error.option",
			trim=true,
			shortCircuit=true
		)
	public String getOptiona() {
		return optiona;
	}
	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}
	@RequiredStringValidator(
			key="error.option",
			trim=true
		)
	public String getOptionb() {
		return optionb;
	}
	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}
	@RequiredStringValidator(
			key="error.option",
			trim=true
		)
	public String getOptionc() {
		return optionc;
	}
	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}
	@RequiredStringValidator(
			key="error.option",
			trim=true
		)
	public String getOptiond() {
		return optiond;
	}
	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}
	@RequiredStringValidator(
			key="error.answer",
			trim=true
		)
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String execute(){
		Item item = new Item(qid, question, "A."+optiona, "B."+optionb, "C."+optionc, "D."+optiond, answer);
		try {
			itemService.AddItem(item);
		} catch (TNAException e) {
			return INPUT;
		}
		return SUCCESS;
	}

}
