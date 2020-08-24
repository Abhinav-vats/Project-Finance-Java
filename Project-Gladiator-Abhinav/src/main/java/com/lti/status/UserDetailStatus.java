package com.lti.status;

import com.lti.dto.UserDetailDto;
import com.lti.entity.Customer;

public class UserDetailStatus {

	private int status;
	private String message;
	private UserDetailDto userDetailDto;
	public UserDetailDto getUserDetailDto() {
		return userDetailDto;
	}
	public void setUserDetailDto(UserDetailDto userDetailDto) {
		this.userDetailDto = userDetailDto;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
