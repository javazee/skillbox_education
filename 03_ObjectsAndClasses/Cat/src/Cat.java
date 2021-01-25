
public class Cat
{
    private double originWeight;
    private double weight;
    private double feedAmount;
    private final double MIN_WEIGHT = 1000.0;//просто поменял предыдущие переменные на константы
    private final double MAX_WEIGHT = 9000.0;//соответственно удалил их с конструктора
    static int count;
    private boolean catAlive;
    private final int TOTAL_EYE = 2;
    private Color color;
    public String name;
    public int age;
    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count ++;
        catAlive = true;
    }
    public Cat(double weight)
    {
        this.weight = weight;
        count ++;
        catAlive = true;
    }
    public Cat (String name, int age)
    {
        this.name = name;
        this.age = age;
        count ++;
        catAlive = true;
    }
    public void meow()
    {
        double meow = originWeight / 20;
        if (!catAlive){
            System.out.println("Мертвые не издают звуков");
        }
        else if (weight < MIN_WEIGHT + meow) {
            weight = weight - meow;
            System.out.println("Кошка мертва. Теперь она никогда не будет мяукать");
            count--;
            catAlive = false;
        } else {
            weight = weight - meow;
            System.out.println("Meow");
        }
    }

    public void feed(Double amount) {
        if (!catAlive) {
            System.out.println("Зачем вы пытатесь накормить мертвую кошку?");
        }
        else if (weight > MAX_WEIGHT - amount) {
            weight = weight + amount;
            feedAmount += amount;
            System.out.println("Кошка мертва. Еда теперь ей больше не пригодится");
            count--;
            catAlive = false;
        }
        else {
            weight = weight + amount;
            feedAmount += amount;
            System.out.println("Поели. Теперь можно и поспать");
        }
    }

    public void drink(Double amount)
    {
        if (!catAlive){
            System.out.println("Зачем вы пытатесь напоить мертвую кошку?");
        }
        else if (weight > MAX_WEIGHT - amount) {
            weight = weight + amount;
            System.out.println("Кошка мертва. Вода теперь ей больше не пригодится");
            count--;
            catAlive = false;
        } else {
            weight = weight + amount;
            System.out.println("Попили. Теперь можно и поспать");
        }
    }

    public Double getWeight()
    {
        return weight;
    }
    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
    public Double getFeedAmount()
    {
        return feedAmount;
    }
    public void pee ()
    {
        double pee = originWeight/20;
        if (!catAlive){
            System.out.println("Мертвые не ходят в туалет");
        }
        else if (weight < MIN_WEIGHT + pee){
            weight = weight - pee;
            System.out.println("Кошка мертва. Теперь у вас всегда будут чистые тапки");
            count--;
            catAlive = false;
        } else {
            weight = weight - pee;
            System.out.println("Кошка нагадила в тапки. Будьте внимательны!");
        }
    }
    public static Integer getCount ()
    {
        return count;
    }
    public Double getOriginWeight ()
    {
        return originWeight;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    public Color getColor()
    {
        return color;
    }
    public String getName ()
    {
        return name;
    }
    public Integer getAge ()
    {
        return age;
    }

}