package com.lti.status;

import java.util.List;

import com.lti.helper.CardDashboardDetail;
import com.lti.helper.ProductDashboard;
import com.lti.helper.TransactionDashboard;

public class DashboardStatus {
	
	private int status;
	private String message;
	private CardDashboardDetail cardDashboardDetail;
	
	private List<ProductDashboard> productList;
	
	private List<TransactionDashboard> transactionList;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public CardDashboardDetail getCardDashboardDetail() {
		return cardDashboardDetail;
	}

	public List<ProductDashboard> getProductList() {
		return productList;
	}

	public List<TransactionDashboard> getTransactionList() {
		return transactionList;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCardDashboardDetail(CardDashboardDetail cardDashboardDetail) {
		this.cardDashboardDetail = cardDashboardDetail;
	}

	public void setProductList(List<ProductDashboard> productList) {
		this.productList = productList;
	}

	public void setTransactionList(List<TransactionDashboard> transactionList) {
		this.transactionList = transactionList;
	}
	
	
	

}
