import java.util.*;

public class Bank {

    private Map<Integer, Account> accounts = new LinkedHashMap<>();

    private final Random random = new Random();

    public boolean isFraud() throws InterruptedException {
        Thread.sleep(100);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public synchronized void transfer(int fromAccountId, int toAccountId, long cashTransfer) throws InterruptedException {

        while (cashTransfer > accounts.get(fromAccountId).getMoney()) {
            try {
                System.out.println(Thread.currentThread().getName() + " - На текущий момент недостаточно денег для перевода");
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        long balanceAccountFrom = accounts.get(fromAccountId).getMoney();
        long balanceAccountTo = accounts.get(toAccountId).getMoney();

        if (fromAccountId != toAccountId) {
            if (cashTransfer > 50000) {
                if (isFraud()) {
                    accounts.get(fromAccountId).setState(State.Blocked);
                    accounts.get(toAccountId).setState(State.Blocked);
                    System.out.println(Thread.currentThread().getName() + " - Подозрение в мошенничестве. Транзакция отменена! Счета временно заблокированы");
                } else {
                    if (accounts.get(fromAccountId).getState().equals(State.Active) && accounts.get(toAccountId).getState().equals(State.Active)) {
                        accounts.get(fromAccountId).setMoney(balanceAccountFrom - cashTransfer);
                        accounts.get(toAccountId).setMoney(balanceAccountTo + cashTransfer);
                        System.out.println(Thread.currentThread().getName() + " - C аккаунта " + fromAccountId +
                                " аккаунту " + toAccountId + " переведена сумма " + cashTransfer + " руб.");
                    } else
                        System.out.println(Thread.currentThread().getName() + " - Транзакция невозможна! Заблокирован один или оба счета");
                }
            } else {
                if (accounts.get(fromAccountId).getState().equals(State.Active) && accounts.get(toAccountId).getState().equals(State.Active)) {
                    accounts.get(fromAccountId).setMoney(balanceAccountFrom - cashTransfer);
                    accounts.get(toAccountId).setMoney(balanceAccountTo + cashTransfer);
                    System.out.println(Thread.currentThread().getName() + " - C аккаунта " + fromAccountId +
                            " аккаунту " + toAccountId + " переведена сумма " + cashTransfer + " руб.");
                } else
                    System.out.println(Thread.currentThread().getName() + " - Транзакция невозможна! Заблокирован один или оба счета");
            }
        } else System.out.println(Thread.currentThread().getName() + " - Перевод внутри счета невозможен!");
        notify();
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(int accountId) {
        return accounts.get(accountId).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;
        for (Map.Entry<Integer, Account> integerAccountEntry : accounts.entrySet()) {
            sum += getBalance(integerAccountEntry.getKey());
        }
        return sum;
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
}
