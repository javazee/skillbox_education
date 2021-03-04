public class Operator implements Employee{
    double salary;
    Company company;

    public Operator (Company company){
        salary = getMonthSalary();
        this.company = company;
    }
    @Override
    public double getMonthSalary() {
        return Math.round(Math.random() * (50000 - 30000) + 20000);
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
