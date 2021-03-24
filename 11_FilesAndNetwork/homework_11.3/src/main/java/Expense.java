public class Expense {
    private Double sum;

    public Double getSum() {
        return sum;
    }

    public void addSum(Double sum) {
        if (this.sum != null) {
            if (sum < 0) {
                System.out.println("Неккоректное значение!");
            } else this.sum += sum;
        } else this.sum = sum;
    }

    public void printInfo(){
        System.out.println("Сумма расходов: " + sum + " руб.");
    }
}
