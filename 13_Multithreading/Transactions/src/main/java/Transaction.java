public class Transaction implements Runnable{

    private final Bank bank;
    private final Account accountSender;
    private final Account accountReceiver;
    private final long cashTransfer;

    public Transaction(Bank bank, Account accountSender, Account accountReceiver, long cashTransfer){
        this.bank = bank;
        this.accountSender = accountSender;
        this.accountReceiver = accountReceiver;
        this.cashTransfer = cashTransfer;
    }

    @Override
    public void run() {
        try {
            bank.transfer(accountSender.getId(), accountReceiver.getId(), cashTransfer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
