package com.oracle.tna.admin.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import com.oracle.tna.exception.TNAException;
import com.oracle.tna.service.ItemService;

@Namespace("/")
@ParentPackage("struts-default")
@Action("dispItemAction")
@Controller
@Scope("prototype")
@Results({
	@Result(name="success" , location=("/admin/modifyItem.jsp")),
	@Result(name="input" ,location=("/admin/itemlist.jsp"))
})
public class DispItemAction  extends ActionSupport
{
	private static final long serialVersionUID = -1367172512909885025L;
	private int qid;
	@Resource
	private ItemService itemService;
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid){
		this.qid = qid;
	}
	
	@Override
	public String execute(){
		Item item = null;
		try {
			item = itemService.FindItem(qid);
		} catch (TNAException e) {
			return INPUT;
		}
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);
		item.setOptionA(item.getOptionA().substring(2));
		item.setOptionB(item.getOptionB().substring(2));
		item.setOptionC(item.getOptionC().substring(2));
		item.setOptionD(item.getOptionD().substring(2));
		request.setAttribute("item", item);
		return SUCCESS;
	}
	
}
