package com.java.bean;



public class User {
	private String uid;
	private String username; 
	private String pwd;
	private String name;
	private String birthday;
	private String gender;
	private String telephone;
	private String email;
	private String status; //是否邮件激活
	private String code; //激活码
	public String getUid() {
		return uid;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public User(String uid, String username, String pwd, String name, String birthday, String gender, String telephone, String email,
			String status, String code) {
		super();
		this.uid = uid;
		this.username = username;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.telephone = telephone;
		this.email = email;
		this.status = status;
		this.code = code;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String string) {
		this.pwd = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", pwd=" + pwd + ", name=" + name + ", birthday="
				+ birthday + ", gender=" + gender + ", telephone=" + telephone + ", email=" + email + ", status="
				+ status + ", code=" + code + "]";
	}
	
	
}
