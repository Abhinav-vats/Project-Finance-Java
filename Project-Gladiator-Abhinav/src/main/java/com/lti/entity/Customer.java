package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer_user_detail")
@NamedQuery(name = "fetch-all-customer", query = "select c from Customer as c")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "customer_seq")
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email_id")
	private String email;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "address")
	private String address;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "bank_account_number")
	private String bankAccountNumber;

	@Column(name = "ifs_code")
	private String ifsCode;

	@Column(name = "is_active")
	private String isActive;
	

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<AllotedCard> alloctedCards;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Document> documents;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetail;
	
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<PaymentSchedule> paymentSchedule;

	public List<PaymentSchedule> getPaymentSchedule() {
		return paymentSchedule;
	}

	public void setPaymentSchedule(List<PaymentSchedule> paymentSchedule) {
		this.paymentSchedule = paymentSchedule;
	}

	public List<AllotedCard> getAlloctedCards() {
		return alloctedCards;
	}

	

	public List<Document> getDocuments() {
		return documents;
	}

	public void setAlloctedCards(List<AllotedCard> alloctedCards) {
		this.alloctedCards = alloctedCards;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getCardType() {
		return cardType;
	}

	public String getBankName() {
		return bankName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public String getIfsCode() {
		return ifsCode;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public void setIfsCode(String ifsCode) {
		this.ifsCode = ifsCode;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
