public class Manager implements Employee{
    double salary;
    static final double fixedSalary = 50000;
    Company company;

    public Manager (Company company){
        salary = getMonthSalary();
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double getMonthSalary() {
        return (fixedSalary + 0.05 * Math.round(Math.random() * (140000 - 115000) + 115000));
    }

    @Override
    public int compareTo(Employee o) {
        if (this.salary == o.getSalary()){
            return 0;
        } else return  this.salary > o.getSalary()? -1: 1;
    }
}
