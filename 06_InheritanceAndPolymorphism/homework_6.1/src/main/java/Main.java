import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        DepositAccount depositAccount = new DepositAccount();
        CardAccount cardAccount = new CardAccount();
        bankAccount.amount = 2000;
        depositAccount.amount = 4000;
        cardAccount.amount = 2000;
        System.out.println("***********************************************\n" +
                "\t\tМанипуляции с банковским счетом\n" +
                "***********************************************");
        System.out.println("Сумма средств на банковском счете: " + bankAccount.getAmount() + " руб.");
        bankAccount.put(500);
        bankAccount.put(-100);
        bankAccount.take(1000);
        bankAccount.take(2000);
        System.out.println("*************************************************\n" +
                "\t\tМанипуляции с депозитным счетом\n" +
                "*************************************************");
        System.out.println("Сумма средств на депозитном счете: " + depositAccount.getAmount() + " руб.");
        depositAccount.put(800);
        depositAccount.put(-52);
        depositAccount.setTime(2021,0,20);
        depositAccount.take(1000);
        depositAccount.setTime(2021,1,22);
        depositAccount.take(1000);
        depositAccount.setTime(2020,1,22);
        depositAccount.take(1000);
        depositAccount.take(1000);
        depositAccount.setTime(2020,1,22);
        depositAccount.take(3000);
        System.out.println("***********************************************\n" +
                "\t\tМанипуляции с кредитным счетом\n" +
                "***********************************************"
        );
        System.out.println("Сумма средств на кредитном счете: " + cardAccount.getAmount() + " руб.");
        cardAccount.put(300);
        cardAccount.put(-100);
        cardAccount.take(900);
        cardAccount.take(2000);
        System.out.println("**********************************************\n" +
                "\tСостояние счетов после всех манипуляций\n" +
                "**********************************************");
        System.out.println("Сумма средств на банковском счете: " + bankAccount.getAmount() + " руб.");
        System.out.println("Сумма средств на депозитном счете: " + depositAccount.getAmount() + " руб.");
        System.out.println("Сумма средств на кредитном счете: " + cardAccount.getAmount() + " руб.");
        System.out.println("****************************************\n" +
                "\t\tПереводы между счетами\n" +
                "****************************************");
        if (bankAccount.send(cardAccount, 1000)) {
            System.out.println("Деньги успешно переведены");
            System.out.println("Сумма средств на банковском счете: " + bankAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на депозитном счете: " + depositAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на кредитном счете: " + cardAccount.getAmount() + " руб.");
        }
        if (cardAccount.send(bankAccount, 1000)) {
            System.out.println("Деньги успешно переведены");
            System.out.println("Сумма средств на банковском счете: " + bankAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на депозитном счете: " + depositAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на кредитном счете: " + cardAccount.getAmount() + " руб.");
        }
        if (cardAccount.send(depositAccount, 1000)) {
            System.out.println("Деньги успешно переведены");
            System.out.println("Сумма средств на банковском счете: " + bankAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на депозитном счете: " + depositAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на кредитном счете: " + cardAccount.getAmount() + " руб.");
        }
        if (cardAccount.send(depositAccount, 369)) {
            System.out.println("Деньги успешно переведены");
            System.out.println("Сумма средств на банковском счете: " + bankAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на депозитном счете: " + depositAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на кредитном счете: " + cardAccount.getAmount() + " руб.");
        }
        depositAccount.setTime(2021,0,20);
        if (depositAccount.send(bankAccount, 1000)) {
            System.out.println("Деньги успешно переведены");
            System.out.println("Сумма средств на банковском счете: " + bankAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на депозитном счете: " + depositAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на кредитном счете: " + cardAccount.getAmount() + " руб.");
        }
        if (depositAccount.send(bankAccount, 100)) {
            System.out.println("Деньги успешно переведены");
            System.out.println("Сумма средств на банковском счете: " + bankAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на депозитном счете: " + depositAccount.getAmount() + " руб.");
            System.out.println("Сумма средств на кредитном счете: " + cardAccount.getAmount() + " руб.");
        }
        }

}
