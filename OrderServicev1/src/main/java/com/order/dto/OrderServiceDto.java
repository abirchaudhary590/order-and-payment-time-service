package com.order.dto;

public class OrderServiceDto {

	private String customerName;
	private double amount;
	private String status;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderServiceDto [customerName=" + customerName + ", amount=" + amount + ", status=" + status + "]";
	}
	
}
