/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @created 28 thg 9, 2025 20:14:35
 */
package core;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 
 */
public class BankAccount {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	
	public BankAccount(String accountNumber, String ownerName, double balance) {
		setAccountNumber(accountNumber);
		setOwnerName(ownerName);
		this.balance = balance;
	}

	public BankAccount() {
		this("0000-0000-0000","No name",0.0);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public void deposit(double amount) {
		if(amount <= 0.0) {
			
		}else {
			this.balance += amount;
		}
	}
	
	public void withdraw(double amount) {
		if(amount <= 0.0 || amount > this.balance) {
			
		}else {
			this.balance -= amount;
		}
	}
	
	public void transfer(BankAccount other, double amount) {
		this.withdraw(amount);
		other.deposit(amount);
	}
	
	@Override
	public String toString() {

		return String.format("%s | %s | %s", 
				getAccountNumber(),
				getOwnerName(),
				nf.format(getBalance()));
	}
}
