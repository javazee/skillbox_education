import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        DepositAccount depositAccount = new DepositAccount();
        CardAccount cardAccount = new CardAccount();
        bankAccount.setAmount(2000);
        depositAccount.setAmount(2000);
        cardAccount.setAmount(2000);
        while (true) {
            System.out.println("На данный момент Вам доступно: " + cardAccount.getAmount() + " руб.");
            System.out.println("Нажмите 1, если хотите снять деньги и 0, если внести");
            Scanner scanner = new Scanner(System.in);
            double input = scanner.nextInt();
            if (input == 1) {
                System.out.print("Введите сумму для снятия: ");
                input = scanner.nextInt();
                cardAccount.take(input);
                System.out.println("Текущий баланс: " + cardAccount.getAmount() + " руб.");
            } else if (input == 0) {
                System.out.print("Введите размер вносимой суммы: ");
                input = scanner.nextInt();
                cardAccount.put(input);
                System.out.println("Текущий баланс: " + cardAccount.getAmount() + " руб.");
            } else {
                System.out.print("Неверный формат ввода!");
            }

        }
    }
}
