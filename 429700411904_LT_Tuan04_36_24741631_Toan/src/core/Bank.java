/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @created 28 thg 9, 2025 20:37:16
 */
package core;

/**
 * 
 */
public class Bank {
	private String name;
	private BankAccount[] accounts;
	private int count;
	
	public Bank(String name, int numberOfAccounts) {
		setName(name);
		this.accounts = new BankAccount[numberOfAccounts];
		this.count = 0;
	}

	public Bank() {
		this("Default Bank", 100);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addNew(String accountNumber, String accountName, double balance) {
		
		accounts[count++] = new BankAccount(accountNumber, accountName, balance);
	}
	
	public BankAccount find(String accountNumber) {
		for (int i = 0; i < count; i++) {
			if(accounts[i].getAccountNumber().equals(accountNumber)) {
				return accounts[i];
			}
		}
		return null;
	}
	
	public double getTotalBalance() {
		double total = 0.0;
		for (int i = 0; i < count; i++) {
			total += accounts[i].getBalance();
		}
		return total;
	}
	
	public int getNumberOfAccounts() {
		return count;
	}
	
    public BankAccount[] getAccounts() {
        BankAccount[] result = new BankAccount[count];
        System.arraycopy(accounts, 0, result, 0, count);
        return result;
    }
}
