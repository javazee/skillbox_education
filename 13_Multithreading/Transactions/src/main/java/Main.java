public class Main {
    public static void main(String[] args) throws InterruptedException {

        //создание банка
        Bank giveMeMoney = new Bank();

        //создание 100 аккаунтов с балансом от 60000 до 100000 руб.
        for (int i = 0; i < 100; i++){
            long balance = Math.round(Math.random() * 40000 + 60000);
            Account a = new Account(i,balance);
            giveMeMoney.addAccount(a);
        }

        //получение информации о общем балансе всех аакаунтов банка
        long startBalance = giveMeMoney.getSumAllAccounts();

        //создание 100 потоков с транзакцией от 20000 до 60000 руб.
        for (int i = 0; i <= 100; i++){
            long transactionSum = Math.round(Math.random() * 40000 + 20000);
            Account a = giveMeMoney.getAccounts().get((int) Math.round(Math.random() * 99));
            Account b = giveMeMoney.getAccounts().get((int) Math.round(Math.random() * 99));
            new Thread(new Transaction(giveMeMoney, a, b, transactionSum)).start();
        }
        Thread.sleep(10000);

        System.out.println("Общая сумма счетов банка до транзакций: " + startBalance + " руб.");
        System.out.println("Общая сумма счетов банка после всех транзакций: " + giveMeMoney.getSumAllAccounts()  + " руб.");

    }
}
