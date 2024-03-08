package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*Banking Application
--------------------
table - ACCOUNTS, TRANSACTIONS
 
/login				- Customer ID & Password => true/false
 
/register			- Customer ID, Password, Account No., IFSC, Type, Mobile
 
/changepwd/cid/abc/xyz		- Customer ID, old password, new password (where cid is custID, abc is old pwd & xyz is new pwd)
 
/transfer?amount=5000		- From_Acctno., To_Account, IFSC, Amount
 
/balance/accountNo		- Display the balance amount in that account (accountNo needs to be passed)
 
/accounts/below?amount=5000 	- Display all accounts below the given balance
 
/accounts/above?amount=100000 	- Display all accounts above the given balance*/
@Entity
@Table(name="Accounts")

public class Account {
         
       	    @Id                 
           	private int cid;    
           	private String password;
           	private int accountno;    
           	private String IFSC; 
           	private String type;
           	private int mobile_no;
           	private int balance;
			public int getBalance() {
				return balance;
			}
			public void setBalance(int balance) {
				this.balance = balance;
			}
			public int getCid() {
				return cid;
			}
			public void setCid(int cid) {
				this.cid = cid;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
		
	
			public int getAccountno() {
				return accountno;
			}
			public void setAccountno(int accountno) {
				this.accountno = accountno;
			}
			public String getIFSC() {
				return IFSC;
			}
			public void setIFSC(String iFSC) {
				IFSC = iFSC;
			}
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
			public int getMobile_no() {
				return mobile_no;
			}
			public void setMobile_no(int mobile_no) {
				this.mobile_no = mobile_no;
			}
           	
           	
           
}