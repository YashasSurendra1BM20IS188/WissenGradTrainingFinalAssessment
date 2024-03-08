package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Transactions")



       	  
public class Transaction {
	@Id                 
 	private int tid;    
 	private int From_Acctno;
 	private int  To_Account;    
 	private String IFSC; 
 	private int Amount;
 	
	  	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getFrom_Acctno() {
		return From_Acctno;
	}
	public void setFrom_Acctno(int from_Acctno) {
		From_Acctno = from_Acctno;
	}
	public int getTo_Account() {
		return To_Account;
	}
	public void setTo_Account(int to_Account) {
		To_Account = to_Account;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
		


}
