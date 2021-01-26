
public class Loader
{
    public static void main(String[] args) {
        //задание 1
        Cat sanya = new Cat();
        Cat murka = new Cat();
        Cat micky = new Cat();
        Cat r2d2 = new Cat();
        System.out.println("вес Сани: " + sanya.getWeight());
        System.out.println("вес Мурки: " + murka.getWeight());
        System.out.println("вес Микки: " + micky.getWeight());
        System.out.println("вес Р2д2: " + r2d2.getWeight());

        sanya.feed(sanya.getWeight() / 100);
        System.out.println("вес кошки после приема еды: " + sanya.getWeight());
        murka.feed(murka.getWeight() / 100);
        System.out.println("вес кошки после приемы еды: " + murka.getWeight());
        System.out.println("====================\n" +
                "   Убиваем кошек!!!\n" +
                "====================");

        while (true) {
            micky.feed(micky.getOriginWeight() / 10);
            if (micky.getStatus() == "Playing" || micky.getStatus() == "Sleeping") {
                System.out.println("Состояние кошки: " + micky.getStatus());
                System.out.println("Вес кошки Микки: " + micky.getWeight() + " г.\n" +
                        "=================================");
            } else {
                System.out.println("Состояние кошки: " + micky.getStatus());
                System.out.println("Вес мертвой кошки: " + micky.getWeight() + " г.\n" +
                        "=================================" +
                        "=================================");
                break;
            }
        }
        micky.meow();
        System.out.println("Состояние кошки: " + micky.getStatus());
        System.out.println("Вес micky: " + micky.getWeight() + " г.\n" +
                "=================================");
        micky.pee();
        System.out.println("Состояние кошки: " + micky.getStatus());
        System.out.println("Вес micky: " + micky.getWeight() + " г.\n" +
                "=================================");
        while (true) {
            r2d2.meow();
            if (r2d2.getStatus() == "Playing" || r2d2.getStatus() == "Sleeping") {
                System.out.println("Состояние кошки: " + r2d2.getStatus());
                System.out.println("Вес R2D2: " + r2d2.getWeight() + " г.\n" +
                        "=================================");
            } else {
                System.out.println("Состояние кошки: " + r2d2.getStatus() + ". Домяукалась.");
                System.out.println("Вес мертвой кошки: " + r2d2.getWeight() + " г.\n" +
                        "=================================" +
                        "=================================");
                break;
            }
        }
        //задание 2
        Cat legolas = new Cat();
        System.out.println("вес кошки: " + legolas.getWeight());
        legolas.feed(100.0);
        System.out.println("вес кошки: " + legolas.getWeight());
        legolas.feed(150.0);
        System.out.println("вес кошки: " + legolas.getWeight());
        legolas.meow();
        legolas.pee();
        System.out.println("Кошка съела " + legolas.getFeedAmount() + " гр.");
        /////////////////////////////
        Cat trump = new Cat(100);
    }
}
