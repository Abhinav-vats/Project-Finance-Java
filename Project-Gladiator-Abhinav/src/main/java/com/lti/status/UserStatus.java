package com.lti.status;

import java.util.List;

import com.lti.dto.CustomerAdminDto;

public class UserStatus {

	private int status;
	private String message;
	private List<CustomerAdminDto> userList;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public List<CustomerAdminDto> getUserList() {
		return userList;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setUserList(List<CustomerAdminDto> userList) {
		this.userList = userList;
	}
	
	

}
