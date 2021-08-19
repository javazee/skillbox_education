import java.sql.*;

public class DBConnection {

    private static Connection connection;

    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "password";
    private static StringBuilder multiInsert = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName, dbUser, dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name TINYTEXT NOT NULL, " +
                    "birthDate DATE NOT NULL, " +
                    "`count` INT NOT NULL, " +
                    "PRIMARY KEY(id), KEY(count), " +
                    "UNIQUE KEY name_date(name(50), birthDate))");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void executeMultiInsert() throws SQLException {
        String sql =
                "INSERT INTO voter_count(name, birthDate, `count`) VALUES" +
                        multiInsert.toString() + "ON DUPLICATE KEY UPDATE `count`=`count` + 1";
        DBConnection.getConnection().createStatement().execute(sql);

    }

    public static void createMultiInsert (String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');
        if (multiInsert.length() > 3000000){
            executeMultiInsert();
            multiInsert.delete(0, multiInsert.length());
        }
        multiInsert.append((multiInsert.length() == 0 ? "" : ",") + "('" + name + "', '" + birthDay + "', 1)");

    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}
