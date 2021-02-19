import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
//        for (String numbers: CoolNumbers.generateCoolNumbers()){
//            System.out.println(numbers);
//        }
        List <String> list = new ArrayList<>(CoolNumbers.generateCoolNumbers());
        String number = list.get((int) Math.round(Math.random() * 2000000));
        long startTime = System.nanoTime();
        long endTime = 0;
        if (CoolNumbers.bruteForceSearchInList(list, number)){
            endTime = System.nanoTime();
            System.out.println("Поиск перебором: номер найден, поиск занял " + (endTime - startTime) + " нс");
        } else {
            endTime = System.nanoTime();
            System.out.println("Поиск перебором: номер yt найден, поиск занял " + (endTime - startTime) + " нс");
        }

        Collections.sort(list);
        startTime = System.nanoTime();
        if (CoolNumbers.binarySearchInList(list, number)){
            endTime = System.nanoTime();
            System.out.println("Бинарный поиск: номер найден, поиск занял " + (endTime - startTime) + " нс");
        } else {
            endTime = System.nanoTime();
            System.out.println("Бинарный поиск: номер не найден, поиск занял " + (endTime - startTime) + " нс");
        }

        HashSet <String> hashset = new HashSet<>(list);
        startTime = System.nanoTime();
        if (CoolNumbers.searchInHashSet(hashset, number)){
            endTime = System.nanoTime();
            System.out.println("Поиск в HashSet: номер найден, поиск занял " + (endTime - startTime) + " нс");
        } else {
            endTime = System.nanoTime();
            System.out.println("Поиск в HashSet: номер не найден, поиск занял " + (endTime - startTime) + " нс");
        }

        TreeSet <String> treeset = new TreeSet<>(list);
        startTime = System.nanoTime();
        if (CoolNumbers.searchInTreeSet(treeset, number)){
            endTime = System.nanoTime();
            System.out.println("Поиск в TreeSet: номер найден, поиск занял " + (endTime - startTime) + " нс");
        } else {
            endTime = System.nanoTime();
            System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + (endTime - startTime) + " нс");
        }

    }

}