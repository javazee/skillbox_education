import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        int size = 2000000; //количество сгенерированных номеров
        Map <Integer, String> letters = new TreeMap<>();
        String[] listOfLetters = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        for (int i = 0; i < listOfLetters.length; i++){
            letters.put(i, listOfLetters[i]);
        }
        List <String> coolNumbers = new ArrayList<>();
        for (int i = 0; i < size; i ++) {
            StringBuilder coolNumber = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                if (j == 0 || j > 3) {
                    int letter = (int) Math.round(Math.random() * (letters.size() - 1));
                    coolNumber.append(letters.get(letter));
                } else {
                    int number = (int) Math.round(Math.random() * 9.49);
                    coolNumber.append(number);
                }
            }
            int regionFirstSign = (int) Math.round(Math.random() * 9.49);
            coolNumber.append(regionFirstSign);
            int regionAnotherSigns = (int) Math.round(Math.random() * 99.49);
            coolNumber.append(regionAnotherSigns);
            coolNumbers.add(coolNumber.toString());
        }
        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (String string: list) {
            if (string.equals(number)){
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) != -1;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
