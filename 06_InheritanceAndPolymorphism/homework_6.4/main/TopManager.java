public class TopManager implements Employee{
    static double salary;
    static String name;
    static final double fixedSalary = 150000;

    public TopManager (){
        name = getName();
        salary = getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        if (Company.getIncome() < 10000000) {
            return fixedSalary;
        } else {
            return 2.5 * fixedSalary;
        }
    }

    public String getName() {
        String[] names = new String[]{"ElonMusk", "JeffBezos", "Galickiy", "Tinkoff"};
        return names[(int) Math.round(Math.random() * (names.length - 1))];
    }
}
