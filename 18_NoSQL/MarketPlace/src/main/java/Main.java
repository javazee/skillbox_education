import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static MongoClient mongoClient = new MongoClient("127.0.0.1" , 27017);
    static MongoDatabase database = mongoClient.getDatabase("local");
    static MongoCollection<Document> shops = database.getCollection("shops");
    static MongoCollection<Document> items = database.getCollection("Items");
    public static void main(String[] args) {
//        shops.drop();
//        items.drop();
        while (true) {
            System.out.println("Введите команду:");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.matches("ДОБАВИТЬ_МАГАЗИН\\s[А-Яа-яЁё]+")) {
                Matcher matcher = Pattern.compile("\\s[А-Яа-яЁё]+").matcher(command);
                if (matcher.find()) {
                    addShop(matcher.group().trim());
                }
            } else if (command.matches("ДОБАВИТЬ_ТОВАР\\s[А-Яа-я]+\\s\\d+")) {
                Matcher item = Pattern.compile("\\s[А-Яа-яЁё]+").matcher(command);
                Matcher price = Pattern.compile("\\d+").matcher(command);
                if (item.find() && price.find()) {
                    addItem(item.group().trim(), Double.parseDouble(price.group()));
                }
            } else if (command.matches("ВЫСТАВИТЬ_ТОВАР\\s[А-Яа-я]+\\s[А-Яа-я]+")) {
                Matcher item = Pattern.compile("\\s[А-Яа-я]+\\s").matcher(command);
                Matcher shop = Pattern.compile("\\s[А-Яа-я]+$").matcher(command);
                if (item.find() && shop.find()) {
                    exposeItem(item.group().trim(), shop.group().trim());
                }
            } else if (command.matches("СТАТИСТИКА_ТОВАРОВ")) {
                getStatistic();
            } else {
                System.out.println("Неверный запрос!");
            }
        }
    }

    static void addShop(String shopName){
        shops.insertOne(new Document().append("Name", shopName));
        System.out.println("Магазин " + shopName + " добавлен");
    }

    static void addItem(String itemName, Double price ){
        items.insertOne(new Document("Name", itemName).append("Price", price));
        System.out.println("Товар " + itemName + " добавлен");
    }

    static void exposeItem(String itemName, String shopName){
        BasicDBObject searchItem = new BasicDBObject();
        searchItem.put("Name", itemName);
        BasicDBObject searchShop = new BasicDBObject();
        searchShop.put("Name", shopName);
        Document item = items.find(searchItem).first();
        Document shop = shops.find(searchShop).first();
        if (shop != null && item != null) {
            Document updatedShop = new Document()
                    .append("Товары", item);
            Document set = new Document()
                    .append("$addToSet", updatedShop);
            shops.updateOne(Objects.requireNonNull(shop), set);
            System.out.println("Товар " + itemName + " выставлен в магазине " + shopName);
        } else System.out.println("Неверный запрос! Указанный магазин или товар отсутствует в базе данных.");
    }

    static void getStatistic(){
        AggregateIterable<Document> firstAggregation = shops.aggregate(Arrays.asList(
                new Document("$unwind", "$Товары"),
                new Document("$sort", new Document("Name", -1)
                        .append("Товары.Price", -1)),
                new Document("$group", new Document("_id", "$Name")
                .append("count", new Document("$sum", 1))
                .append("avg", new Document("$avg", "$Товары.Price"))
                .append("min", new Document("$last", "$Товары"))
                .append("max", new Document("$first", "$Товары")))
        ));

        AggregateIterable<Document> secondAggregation = shops.aggregate(Arrays.asList(
                new Document("$unwind", "$Товары"),
                new Document("$match", new Document("Товары.Price", new Document("$lt", 100))),
                new Document("$group", new Document("_id", "$Name")
                        .append("count", new Document("$sum", 1)))
        ));

        for (Document db1 : firstAggregation)
        {
            Document nameFieldOfMax = (Document) db1.get("max");
            Document nameFieldOfMin = (Document) db1.get("min");
            Document priceFieldOfMax = (Document) db1.get("max");
            Document priceFieldOfMin = (Document) db1.get("min");
            System.out.println("\t\t\tСтатистика по магазину " + db1.get("_id"));
            System.out.println("Количество товаров: " + db1.get("count"));
            System.out.println("Средняя цена товаров: " + db1.get("avg") + " руб.");
            System.out.println("Самый дорогой товар " + nameFieldOfMax.get("Name") + " по цене: " + priceFieldOfMax.get("Price") + " руб.");
            System.out.println("Самый дешевый товар " + nameFieldOfMin.get("Name") + " по цене: " + priceFieldOfMin.get("Price") + " руб.");
            for (Document db2 : secondAggregation) {
                if (db1.get("_id").equals(db2.get("_id"))) {
                    System.out.println("Количество товаров дешевле 100 рублей: " + db2.get("count"));
                }
            }
        }
    }
}
