package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "otp_manager")
public class OtpManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "otp_seq")
	@SequenceGenerator(sequenceName = "otp_seq", allocationSize = 1, name = "otp_seq")
	@Column(name = "id")
	private int id;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "otp")
	private String otp;

	public int getId() {
		return id;
	}
	public String getEmailId() {
		return emailId;
	}

	public String getOtp() {
		return otp;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	

}
