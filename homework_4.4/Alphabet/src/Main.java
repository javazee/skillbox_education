public class Main {
    public static void main(String[] args) {
        for(int i =0; i < "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".length(); i ++){
            System.out.println("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".charAt(i) + ": " + (int) "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".charAt(i));
        }

        String rusAlphabet = "АаБбВвГгДдЕеЖжЗзИиЙйКкЛлНнОоПпРрСсТтУуФфХхЦцЧчЩщШшьыъЭэЮюЯя";
        for(int i =0; i < rusAlphabet.length(); i ++){
            char symbol = rusAlphabet.charAt(i);
            int symbolCode = (int) symbol;
            System.out.println(rusAlphabet.charAt(i) + ": " + symbolCode);
        }
    }
}
