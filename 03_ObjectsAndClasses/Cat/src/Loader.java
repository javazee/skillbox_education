
public class Loader
{
    public static void main(String[] args)
    {
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
            micky.feed(micky.getOriginWeight()/10);
            if (micky.getStatus() == "Playing" || micky.getStatus() == "Sleeping"){
                System.out.println("Состояние кошки: " + micky.getStatus());
                System.out.println("Вес кошки Микки: " + micky.getWeight() + " г.\n" +
                        "=================================");
            }
            else{
                System.out.println("Состояние кошки: " + micky.getStatus());
                System.out.println("Вес мертвой кошки: " + micky.getWeight() + " г.\n" +
                        "=================================" +
                        "=================================");
                break;
            }
        }
        while (true) {
            r2d2.meow();
            if (r2d2.getStatus() == "Playing" || r2d2.getStatus() == "Sleeping"){
                System.out.println("Состояние кошки: " + r2d2.getStatus());
                System.out.println("Вес R2D2: " + r2d2.getWeight() + " г.\n" +
                        "=================================");
            }
            else {
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
        System.out.println("Кошка съела " + legolas.getFeedAmount() + " гр.");
        //////////////////////////////
        System.out.println("=================================");
        /////////////////////////////
        System.out.println("Саня весит " + sanya.getWeight() +" гр.");
        sanya.pee();
        System.out.println("Саня весит " + sanya.getWeight() +" гр.");
        sanya.pee();
        System.out.println("Саня весит " + sanya.getWeight() +" гр.");
        sanya.pee();
        System.out.println("Саня весит " + sanya.getWeight() +" гр.");
        sanya.pee();
        System.out.println("Саня весит " + sanya.getWeight() +" гр.");
        System.out.println("===========================================");
        //задание 3
        System.out.println("Количество живых кошек на данный момент: " + Cat.getCount());
        micky.feed(micky.getOriginWeight()/10);
        r2d2.meow();
        System.out.println("===========================================");
        //задание 5
        Cat vasya = getKitten(1200);
        System.out.println("Вес Васи: " + vasya.getWeight());
        Cat petya = getKitten(1100);
        System.out.println("Вес Пети: " + petya.getWeight());
        Cat masha = getKitten(1300);
        System.out.println("Вес Маши: " + masha.getWeight());
        System.out.println("Количество живых кошек на данный момент: " + Cat.getCount());
        System.out.println("===============================================");
        //задание 6
        murka.setColor(Color.BROWN);
        System.out.println(murka.getColor());
        System.out.println("===============================================");
        //задание 7
        Cat tom = new Cat ("Tom", 7 );
        System.out.println("Котенок " + tom.name);
        System.out.println("Возраст, лет: " + tom.age);
        Cat tommy = new Cat(tom.getName(), tom.getAge());
        System.out.println("Котенок " + tommy.name);
        System.out.println("Возраст, лет: " + tommy.age);
        System.out.println("Количество живых кошек на данный момент: " + Cat.getCount());
    }
        private static Cat getKitten(double weight)
        {
            Cat cat = new Cat (weight);
            //Cat cat = new Cat(1100);//не совсем понял задание. Если всегда надо возвращать кошку с массой 1100,
                                      //независимо от передаваемого значения в конструктор, то надо использовать этот вариант
            return cat;
        }
}