package com.lti.status;


import java.util.List;

import com.lti.entity.Customer;
public class UserStatus {


	
	private int status;
	private String message;
	private List<Customer> userList;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public List<Customer> getUserList() {
		return userList;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setUserList(List<Customer> userList) {
		this.userList = userList;
	}

}
