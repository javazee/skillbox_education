import java.util.Map;
import java.util.TreeMap;

public class Company {
    Map <Double, String> listOfEmployee = new TreeMap<>();

    void hire(){
        if (Math.random() < 0.01){
            new TopManager();
            listOfEmployee.put(TopManager.salary, TopManager.name);
            System.out.println(TopManager.salary);
            System.out.println(TopManager.name);

        } else if (Math.random() < 0.1){
            new Manager();
            listOfEmployee.put(Manager.salary, Manager.name);
            System.out.println(Manager.salary);
            System.out.println(Manager.name);
        } else {
            new Operator();
            listOfEmployee.put(Operator.salary, Operator.name);
            System.out.println(Operator.salary);
            System.out.println(Operator.name);
        }
    }
    void hireAll(int number){
        for (int i = 0; i < number; i++){
            hire();
        }
    }
    void fire(){
    }
    public static double getIncome(){
        return Math.round(Math.random() * (15000000 - 5000000) + 5000000);
    }
}
