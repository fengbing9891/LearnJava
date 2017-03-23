package com.dao.test;

@Table("department")
public class Department {

	@Column("depId")
	private int depId;
	
	@Column("depName")
	private String depName;
	
	@Column("amount")
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	
	
}
