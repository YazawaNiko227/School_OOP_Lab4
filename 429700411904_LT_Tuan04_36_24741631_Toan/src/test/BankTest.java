/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @created 28 thg 9, 2025 22:06:49
 */
package test;

import core.Bank;
import core.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testAddNewAccount() {
        Bank bank = new Bank("TestBank", 10);
        bank.addNew("123", "Toan", 1000);
        assertEquals(1, bank.getNumberOfAccounts());
        assertNotNull(bank.find("123"));
    }

    @Test
    public void testAddDuplicateAccount() {
        Bank bank = new Bank("TestBank", 10);
        bank.addNew("123", "Toan", 1000);
        assertThrows(IllegalArgumentException.class, () -> bank.addNew("123", "Linh", 500));
    }

    @Test
    public void testBankIsFull() {
        Bank bank = new Bank("TestBank", 1);
        bank.addNew("123", "Toan", 1000);
        assertThrows(IllegalArgumentException.class, () -> bank.addNew("456", "Linh", 500));
    }

    @Test
    public void testGetTotalBalance() {
        Bank bank = new Bank("TestBank", 10);
        bank.addNew("123", "Toan", 1000);
        bank.addNew("456", "Linh", 2000);
        assertEquals(3000, bank.getTotalBalance());
    }

    @Test
    public void testFindAccount() {
        Bank bank = new Bank("TestBank", 10);
        bank.addNew("123", "Toan", 1000);
        BankAccount acc = bank.find("123");
        assertNotNull(acc);
        assertEquals("Toan", acc.getOwnerName());
    }

    @Test
    public void testFindNonExistentAccount() {
        Bank bank = new Bank("TestBank", 10);
        assertNull(bank.find("999"));
    }
}
