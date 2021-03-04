public class TopManager implements Employee{
    double salary;
    static final double fixedSalary = 150000;
    Company company;

    public TopManager (Company company){
        salary = getMonthSalary();
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        if (Company.getIncome() < 10000000) {
            return fixedSalary;
        } else {
            return 2.5 * fixedSalary;
        }
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.salary == o.getSalary()){
            return 0;
        } else return  this.salary > o.getSalary()? -1: 1;
    }
}
