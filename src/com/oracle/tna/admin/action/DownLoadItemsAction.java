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
import com.oracle.tna.service.ItemService;

@Namespace("/user")
@ParentPackage("struts-default")
@Action("DownLoadItems")
@Controller
@Scope("prototype")
@Results({
	@Result(name="input", location="/admin/index.jsp"),
	@Result(name="success",type="redirect", location="/admin/DownLoadSuc.jsp")
})	
public class DownLoadItemsAction extends ActionSupport {

	private static final long serialVersionUID = -2063304687047975419L;
	@Resource
	private ItemService itemService;
	
	@Override
	public String execute() throws Exception {
		itemService.downLoadItems();
		return SUCCESS;
	}
	
}
