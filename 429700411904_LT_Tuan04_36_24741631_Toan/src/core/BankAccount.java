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

	public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be greater than 0");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            throw new IllegalArgumentException("Amount must be greater than 0 and less than or equal to balance");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void transfer(BankAccount other, double amount) {
        this.withdraw(amount);
        other.deposit(amount);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty())
            throw new IllegalArgumentException("The account number must not be null");
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isEmpty())
            throw new IllegalArgumentException("The owner name must not be null");
        this.ownerName = ownerName;
    }
	
	@Override
	public String toString() {

		return String.format("%15s | %15s | %20s", 
				getAccountNumber(),
				getOwnerName(),
				nf.format(getBalance()));
	}
}
