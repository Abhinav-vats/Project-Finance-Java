package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "document_upload")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_upload_seq")
	@SequenceGenerator(sequenceName = "document_upload_seq", allocationSize = 1, name = "document_upload_seq")
	@Column(name = "id")
	private int id;

	@Column(name = "document_type")
	private String documentType;

	@Column(name = "document_path")
	private String documentPath;

	@Column(name = "verification_status")
	private String verificationStatus;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Customer customer;

	public int getId() {
		return id;
	}

	public String getDocumentType() {
		return documentType;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
