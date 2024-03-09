import com.app.transactionsystem.model.BankAccount;
import com.app.transactionsystem.service.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankingSystemTest {

    @Test
    public void testWithdrawSufficientFunds() {
        BankAccount account = new BankAccount(123, 1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount(456, 200);
        account.withdraw(300);
        assertEquals(200, account.getBalance(), 0.01);
    }

    @Test
    public void testDepositValidAmount() {
        BankAccount account = new BankAccount(789, 100);
        account.deposit(200);
        assertEquals(300, account.getBalance(), 0.01);
    }

    @Test
    public void testDepositInvalidAmount() {
        BankAccount account = new BankAccount(101, 500);
        account.deposit(-200);
        assertEquals(500, account.getBalance(), 0.01);
    }

    @Test
    public void testTransactionDeposit() {
        BankAccount account = new BankAccount(111, 100);
        Transaction depositTransaction = new Transaction(account, 200, true);
        depositTransaction.run();
        assertEquals(300, account.getBalance(), 0.01);
    }

    @Test
    public void testTransactionWithdrawal() {
        BankAccount account = new BankAccount(222, 500);
        Transaction withdrawalTransaction = new Transaction(account, 300, false);
        withdrawalTransaction.run();
        assertEquals(200, account.getBalance(), 0.01);
    }
}
