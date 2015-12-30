package com.oracle.tna.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String adminUserName;
	private String password;
	private String name;
	private String idnum;
	private String tel;
	private String mngcom;
	private String role;
	private Timestamp lastlogintime; 
	
	public AdminUser() {
		super();
	}

	public AdminUser(int aid, String adminUserName, String password) {
		super();
		this.aid = aid;
		this.adminUserName = adminUserName;
		this.password = password;
	}
	
	
	
	public AdminUser(int aid, String adminUserName, String password,
			String name, String idnum, String tel, String mngcom, String role) {
		super();
		this.aid = aid;
		this.adminUserName = adminUserName;
		this.password = password;
		this.name = name;
		this.idnum = idnum;
		this.tel = tel;
		this.mngcom = mngcom;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMngcom() {
		return mngcom;
	}

	public void setMngcom(String mngcom) {
		this.mngcom = mngcom;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(Timestamp lastlogintime) {
		this.lastlogintime = lastlogintime;
	}


	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String
				.format("AdminUser [aid=%s, adminUserName=%s, password=%s, name=%s, idnum=%s, tel=%s, mngcom=%s, role=%s, lastlogintime=%s]",
						aid, adminUserName, password, name, idnum, tel, mngcom,
						role, lastlogintime);
	}
	
	
	
}
