package com.oracle.tna.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4813784009031676511L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int menuid;
	
	private String name;
	private String url;
	@Column(name = "parentmenu")
	private int parentMenu;
	
	public Menu(String name, String url, int parentMenu) {
		super();
		this.name = name;
		this.url = url;
		this.parentMenu = parentMenu;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(int parentMenu) {
		this.parentMenu = parentMenu;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Menu [menuid=%s, name=%s, url=%s, parentMenu=%s]", menuid,
				name, url, parentMenu);
	}

}
