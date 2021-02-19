import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        CoolNumbers.bruteForceSearchInList(list, number);
        Collections.sort(list);
    }

}