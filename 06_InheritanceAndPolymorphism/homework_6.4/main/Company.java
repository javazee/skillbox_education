import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    String name;
    public Company(String name) {
        this.name = name;
    }

    List<Employee> listOfEmployee = new ArrayList<>();

    void hire(Employee employee) {
        if (employee instanceof TopManager) {
            listOfEmployee.add(new TopManager(this));

        } else if (employee instanceof Manager) {
            new Manager(this);
            listOfEmployee.add(new Manager(this));
        } else {
            new Operator(this);
            listOfEmployee.add(new Operator(this));
        }
    }

    void hireAll(int number, Employee employee) {
        List<Employee> newStaff = new ArrayList<>();
        if (employee instanceof TopManager){
            for (int i = 0; i < number; i++) {
                newStaff.add(new TopManager(this));
            }
        }
        if (employee instanceof Manager){
            for (int i = 0; i < number; i++) {
                newStaff.add(new Manager(this));
            }
        }
        if (employee instanceof Operator){
            for (int i = 0; i < number; i++) {
                newStaff.add(new Operator(this));
            }
        }
        listOfEmployee.addAll(newStaff);
    }
    void fire(int count) {
        if (count < getCompanySize()) {
            for (int i = 0; i < Math.abs(count); i++) {
                listOfEmployee.remove((int) Math.round(Math.random() * (getCompanySize() - 1)));
            }
            System.out.println("Количество сотрудников компании " + name  + " после сокращения: " + getCompanySize());
        } else System.out.println("Вы хотите уволить слишком много людей");
    }

    public int getCompanySize(){
        return listOfEmployee.size();
    }

    public static double getIncome() {
        return Math.round(Math.random() * (15000000 - 5000000) + 5000000);
    }

    List<Employee> getTopSalaryStaff(int count){
        if (count > 0) {
            Collections.sort(listOfEmployee);
            if (count < getCompanySize()) {
                List<Employee> topSalaries = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    topSalaries.add(listOfEmployee.get(i));
                }
                return topSalaries;
            }
        }
        return listOfEmployee;
    }

    List<Employee> getLowestSalaryStaff(int count){
        if (count > 0) {
            listOfEmployee.sort(Collections.reverseOrder());
            if (count < getCompanySize()) {
                List<Employee> lowestSalaries = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    lowestSalaries.add(listOfEmployee.get(i));
                }
                return lowestSalaries;
            }
        }
        return listOfEmployee;
    }
}
