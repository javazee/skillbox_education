public class Main {

  public static void main(String[] args) {
    int sum = calculateSalarySum(" Вася заработал 50000р, Катя - 30000 р., а Коля 56000");
    System.out.println(sum);
  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    String onlyDigit = (text.replaceAll("[^0-9]"," ")).trim();
    if (onlyDigit.equals("")){
      return 0;
    }
    String[] salaries = onlyDigit.split("\\s+");
    int salarySum = 0;
    for (int i = 0; i < salaries.length; i++) {
      salarySum = salarySum + Integer.parseInt(salaries[i]);
    }
    return salarySum;
  }

}