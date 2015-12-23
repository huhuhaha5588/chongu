package com.oracle.tna.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = -184000017735022520L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	private String username;
	private String password;
	private String name;
	private String idnum;
	private String tel;
	
	public User(String username, String password, String name,
			String idnum, String tel) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.idnum = idnum;
		this.tel = tel;
	}

	public User(int uid, String username, String password, String name,
			String idnum, String tel) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.idnum = idnum;
		this.tel = tel;
	}

	public User() {
		super();
	}

	
	
	
	public int getUid() {
		return uid;
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

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username
				+ ", password=" + password + ", name=" + name
				+ ", idnum=" + idnum + ", tel=" + tel + "]";
	}
	

	


}
