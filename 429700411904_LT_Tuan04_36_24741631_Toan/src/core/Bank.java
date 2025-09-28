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

    public Bank() {
        this("Default Bank", 100);
    }

    public Bank(String name, int numberOfAccounts) {
        if (numberOfAccounts <= 0)
            throw new IllegalArgumentException("Number of accounts must be greater than 0");

        setName(name);
        this.accounts = new BankAccount[numberOfAccounts];
        this.count = 0;
    }

    public void addNew(String accountNumber, String accountName, double balance) {
        if (count >= accounts.length)
            throw new IllegalArgumentException("Bank is full");

        if (find(accountNumber) != null)
            throw new IllegalArgumentException("Account number already exists");

        accounts[count++] = new BankAccount(accountNumber, accountName, balance);
    }

    public BankAccount find(String accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    public double getTotalBalance() {
        double total = 0;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("The bank name must not be null");
        this.name = name;
    }
}
