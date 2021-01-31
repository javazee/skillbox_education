public class Main {
    public static void main(String[] args) {
        for(char i = 'a'; i <= 'z'; i++){
            System.out.println(i + ": " + (int) i);
        }
        for(char i = 'A'; i <= 'Z'; i++){
            System.out.println(i + ": " + (int) i);
        }
        for(char i = 'а'; i <= 'я'; i++){
            if ( i =='ж'){
                System.out.println('ё' + ": " + (int) 'ё');
            }
            System.out.println(i + ": " + (int) i);
        }
        for(char i = 'А'; i <= 'Я'; i++){
            if ( i =='Ж'){
                System.out.println('Ё' + ": " + (int) 'Ё');
            }
            System.out.println(i + ": " + (int) i);
        }
    }
}
