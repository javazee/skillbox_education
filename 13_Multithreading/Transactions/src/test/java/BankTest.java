import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BankTest extends TestCase {
    Map<Integer, Account> accounts;
    Bank bank;
    Account a;
    Account b;

    @Override
    protected void setUp() throws Exception {
        accounts = new HashMap<>();
        bank = new Bank();
        a = new Account(1, 40000);
        b = new Account(2, 40000);
    }

    @Test
    public void testTransfer() throws InterruptedException {
        Bank bank = new Bank();
        long balance = 60000;
        long transactionSum = 55000;
        for (int i = 0; i < 100; i++){
            Account a = new Account(i,balance);
            bank.addAccount(a);
        }
        for (int i = 0; i < 100; i++){
            Account a = bank.getAccounts().get((int) Math.round(Math.random() * 99));
            Account b = bank.getAccounts().get((int) Math.round(Math.random() * 99));
            new Thread(new Transaction(bank, a, b, transactionSum)).start();
        }
        Thread.sleep(10000);
        long actual = bank.getSumAllAccounts();
        long expected = 6000000;
        assertEquals(expected, actual);
    }

    @Test
    public void testTransferOnDeadLock() throws InterruptedException {
        bank.addAccount(a);
        bank.addAccount(b);
        for (int i = 0; i < 100; i++) {
            new Thread(new Transaction(bank, a, b, 1000)).start();
            new Thread(new Transaction(bank, b, a, 1000)).start();
        }
        Thread.sleep(1000);
        long actual = a.getMoney();
        long expected = 40000;
        assertEquals(expected, actual);
    }

    @Test
    public void testTransferMultiThread() throws InterruptedException {
        Bank newBank = new Bank();
        for (int i = 0; i < 100; i++){
            newBank.addAccount(new Account(i, 40000));
            new Thread(new Transaction(newBank, newBank.getAccounts().get(0), newBank.getAccounts().get(i), 100)).start();
        }
        Thread.sleep(10000);
        long actual = newBank.getAccounts().get(0).getMoney();
        long expected = 30100;
        assertEquals(expected, actual);
    }

    @Test
    public void testTransferWithInsufficientBalance() throws InterruptedException {
        bank.addAccount(a);
        bank.addAccount(b);
        new Thread(new Transaction(bank, a, b, 45000)).start();
        Thread.sleep(1000);
        new Thread(new Transaction(bank, b, a, 10000)).start();
        Thread.sleep(3000);
        long actual = a.getMoney();
        long expected = 5000;
        assertEquals(expected, actual);
    }

    @Test
    public void testTransferFromOneAccount() throws InterruptedException {
        bank.addAccount(a);
        bank.addAccount(b);
        new Thread(new Transaction(bank, a, b, 45000)).start();
        Thread.sleep(1000);
        new Thread(new Transaction(bank, a, b, 10000)).start();
        Thread.sleep(1000);
        long actual = a.getMoney();
        long expected = 30000;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
