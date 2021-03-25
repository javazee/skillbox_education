public class ExpenseItem {
    private final String name;
    private Double sum;

    public ExpenseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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

    @Override
    public String toString() {
        return getName() + ": " + getSum() + " руб.";
    }
}
