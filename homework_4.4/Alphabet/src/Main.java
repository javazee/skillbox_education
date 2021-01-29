public class Main {
    public static void main(String[] args) {
        String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        for(int i =0; i < alphabet.length(); i ++){
            char symbol = alphabet.charAt(i);
            int symbolCode = (int) symbol;
            System.out.println(alphabet.charAt(i) + ": " + symbolCode);
        }

        String rusAlphabet = "АаБбВвГгДдЕеЖжЗзИиЙйКкЛлНнОоПпРрСсТтУуФфХхЦцЧчЩщШшьыъЭэЮюЯя";
        for(int i =0; i < rusAlphabet.length(); i ++){
            char symbol = rusAlphabet.charAt(i);
            int symbolCode = (int) symbol;
            System.out.println(rusAlphabet.charAt(i) + ": " + symbolCode);
        }
    }
}
