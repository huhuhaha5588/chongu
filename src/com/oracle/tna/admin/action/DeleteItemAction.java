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
import com.oracle.tna.exception.TNAException;
import com.oracle.tna.service.ItemService;
@Namespace("/")
@ParentPackage("struts-default")
@Action("deleteitem")
@Controller
@Scope("prototype")
@Results({
	@Result(name="success" ,type="redirect", location=("/admin/itemlist.jsp")),
	@Result(name="input" ,type="redirect", location=("/admin/itemlist.jsp"))
})
public class DeleteItemAction extends ActionSupport
{

	private static final long serialVersionUID = 1L;
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
		try {
			itemService.DeleteItem(qid);
		} catch (TNAException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
}
