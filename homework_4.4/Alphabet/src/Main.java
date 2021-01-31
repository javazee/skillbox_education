public class Main {
    public static void main(String[] args) {
        for(char i = 'a'; i <= 'z'; i++){
            System.out.println(i + ": " + (int) i);
        }
        for(char i = 'A'; i <= 'Z'; i++){
            System.out.println(i + ": " + (int) i);
        }
        for(char i = 'а'; i <= 'я'; i++){
            System.out.println(i + ": " + (int) i);
        }
        for(char i = 'А'; i <= 'Я'; i++){
            System.out.println(i + ": " + (int) i);
        }
    }
}
