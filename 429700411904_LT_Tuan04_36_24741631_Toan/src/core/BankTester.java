/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @created 28 thg 9, 2025 21:22:28
 */
package core;

import java.util.Scanner;

public class BankTester {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("MyBank", 100);

        while (true) {
            System.out.println("\nWelcome to IUH Bank ");
            System.out.println("1. Open new account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. The total balance of all bank accounts in the bank");
            System.out.println("6. Print all bank accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice:  ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
            case 1:
                System.out.print("Enter account number: ");
                String accNum = scanner.nextLine();
                System.out.print("Enter owner name: ");
                String owner = scanner.nextLine();
                System.out.print("Enter initial balance: ");
                double initBalance = scanner.nextDouble();
                scanner.nextLine();
                try {
                    bank.addNew(accNum, owner, initBalance);
                    System.out.println("Account created successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 2:
                System.out.print("Enter account number: ");
                String depAccNum = scanner.nextLine();
                BankAccount depAcc = bank.find(depAccNum);
                if (depAcc != null) {
                    System.out.print("Enter deposit amount: ");
                    double depAmount = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        depAcc.deposit(depAmount);
                        System.out.println("Deposit successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Account not found.");
                }
                break;

            case 3:
                System.out.print("Enter account number: ");
                String withAccNum = scanner.nextLine();
                BankAccount withAcc = bank.find(withAccNum);
                if (withAcc != null) {
                    System.out.print("Enter withdrawal amount: ");
                    double withAmount = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        withAcc.withdraw(withAmount);
                        System.out.println("Withdrawal successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Account not found.");
                }
                break;

            case 4:
                System.out.print("Enter sender account number: ");
                String senderAccNum = scanner.nextLine();
                BankAccount sender = bank.find(senderAccNum);
                System.out.print("Enter receiver account number: ");
                String receiverAccNum = scanner.nextLine();
                BankAccount receiver = bank.find(receiverAccNum);
                if (sender != null && receiver != null) {
                    System.out.print("Enter transfer amount: ");
                    double transAmount = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        sender.transfer(receiver, transAmount);
                        System.out.println("Transfer successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("One or both accounts not found.");
                }
                break;

            case 5:
                System.out.printf("Total balance in bank: %.2f VND\n", bank.getTotalBalance());
                break;

            case 6:
            	System.out.printf("%15s | %15s | %20s","Account Number", "Owner Name", "Balance");
                BankAccount[] allAccounts = bank.getAccounts();
                for (BankAccount acc : allAccounts) {
                    System.out.println(acc);
                }
                break;

            case 7:
                System.out.println("Thank you for using IUH Bank. Goodbye!");
                return;

            default:
                System.out.println("Invalid choice. Please try again.");
            }
            scanner.close();
        }
    }
}