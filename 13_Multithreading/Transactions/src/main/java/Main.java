public class Main {
    public static void main(String[] args) throws InterruptedException {

        //создание банка
        Bank giveMeMoney = new Bank();

//        new Thread(()->{
//            Account a = new Account(1, 60000);
//            Account b = new Account(2, 60000);
//            giveMeMoney.addAccount(a);
//            giveMeMoney.addAccount(b);
//            try {
//                giveMeMoney.transfer(a.getId(), b.getId(), 40000);
//                System.out.println(giveMeMoney.getBalance(a.getId()));
//                System.out.println(giveMeMoney.getBalance(b.getId()));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        //создание 100 аккаунтов с балансом от 60000 до 100000 руб.
        for (int i = 0; i < 100; i++){
            long balance = Math.round(Math.random() * 40000 + 60000);
            Account a = new Account(i,balance);
            giveMeMoney.addAccount(a);
        }

        //получение информации о общем балансе всех аакаунтов банка
        long startBalance = giveMeMoney.getSumAllAccounts();

        //создание 500 потоков с транзакцией от 20000 до 60000 руб.
        for (int i = 0; i <= 500; i++){
            long transactionSum = Math.round(Math.random() * 40000 + 20000);
            Account a = giveMeMoney.getAccounts().get((int) Math.round(Math.random() * 99));
            Account b = giveMeMoney.getAccounts().get((int) Math.round(Math.random() * 99));
            new Thread(new Transaction(giveMeMoney, a, b, transactionSum)).start();
        }
        Thread.sleep(5000);

        System.out.println("Общая сумма счетов банка до транзакций: " + startBalance + " руб.");
        System.out.println("Общая сумма счетов банка после всех транзакций: " + giveMeMoney.getSumAllAccounts()  + " руб.");
    }
}
