import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RedisStorage storage = new RedisStorage("users");

        storage.flush();

        int usersCount = 20;

        int count = 0;

        //создание спика пользователей
        for (int i = 0; i < usersCount; i++){
            Thread.sleep(10);
            storage.addUser(i);
        }

        while (true) {
            for (int i = 0; i < usersCount; i++) {
                count++;
                Thread.sleep(1000);
                if (count % 10 == 0) {
                    int randomUser = new Random().nextInt(usersCount);
                    storage.updateUser(randomUser);
                    System.out.println("Пользователь " + randomUser + " оплатил платную подписку");
                    System.out.println("На главное странице показываем пользователя " + randomUser);
                    continue;
                }
                System.out.println("На главное странице показываем пользователя " + storage.getLastUserValue());
            }
        }
    }
}
