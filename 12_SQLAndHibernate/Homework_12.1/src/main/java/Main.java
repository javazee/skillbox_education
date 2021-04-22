import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
        try {
            String user = "root";
            String password = "write password here";
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select course_name, " +
                    "round((count(course_name))/((month(max(subscription_date))) - (month(min(subscription_date))) + 1), 3) " +
                    "as average_monthly_sales from purchaselist where year(subscription_date) = 2018 group by course_name;");
            while (resultSet.next()){
                System.out.println(resultSet.getString("course_name") + " - " + resultSet.getString("average_monthly_sales") + " продаж в месяц");
            }
            connection.close();
            resultSet.close();
            statement.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
