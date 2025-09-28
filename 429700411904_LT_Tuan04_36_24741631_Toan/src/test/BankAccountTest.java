/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @created 28 thg 9, 2025 22:07:01
 */
package test;

/**
 * 
 */
import core.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDepositValidAmount() {
        BankAccount acc = new BankAccount("123", "Toan", 1000);
        acc.deposit(500);
        assertEquals(1500, acc.getBalance());
    }

    @Test
    public void testDepositInvalidAmount() {
        BankAccount acc = new BankAccount("123", "Toan", 1000);
        assertThrows(IllegalArgumentException.class, () -> acc.deposit(-100));
    }

    @Test
    public void testWithdrawValidAmount() {
        BankAccount acc = new BankAccount("123", "Toan", 1000);
        acc.withdraw(400);
        assertEquals(600, acc.getBalance());
    }

    @Test
    public void testWithdrawInvalidAmount() {
        BankAccount acc = new BankAccount("123", "Toan", 1000);
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(2000));
    }

    @Test
    public void testTransferValid() {
        BankAccount acc1 = new BankAccount("123", "Toan", 1000);
        BankAccount acc2 = new BankAccount("456", "Linh", 500);
        acc1.transfer(acc2, 300);
        assertEquals(700, acc1.getBalance());
        assertEquals(800, acc2.getBalance());
    }

    @Test
    public void testTransferInvalid() {
        BankAccount acc1 = new BankAccount("123", "Toan", 1000);
        BankAccount acc2 = new BankAccount("456", "Linh", 500);
        assertThrows(IllegalArgumentException.class, () -> acc1.transfer(acc2, 2000));
    }
}