//username: root , password : Akshay
import java.sql.*;
public class BasicQuery {

    private static Connection connection = null;


    private BasicQuery() {}

    public static void main(String[] args) throws SQLException {
        if (connection == null) {
            String url = "jdbc:mysql://localhost/feedback";
            String username = "root";
            String password = "Akshay";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected");
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL Driver not found. Please download and add the driver.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //executing query
        System.out.println("Creating statement...");
        Statement statement = connection.createStatement(); //taking statement


       /* String sql1= "insert into comments values\n" +
                "(3,'Varsha','varsha.deosthale6@gmail.com','localhost2.com',curdate(),'nothing here as well yayaya','awesome nhi hai re baba')";
        statement.executeUpdate(sql1); */

        String sql = "SELECT * FROM comments";
        ResultSet rs= statement.executeQuery(sql);//storing o/p of above command in rs

        //extract data from result set (rs also works as an iterator)
        while (rs.next()) {
            //assigning values according to column name
            int id = rs.getInt("id");
            String name = rs.getString("MYUSER");
            String email = rs.getString("EMAIL");
            String webpage = rs.getString("WEBPAGE");
            String date = rs.getString("DATUM");
            String summary = rs.getString("SUMMARY");
            String comments = rs.getString("COMMENTS");

            //display values
            System.out.println(id);
            System.out.println(name);
            System.out.println(email);
            System.out.println(webpage);
            System.out.println(date);
            System.out.println(summary);
            System.out.println(comments);
            System.out.println();
            System.out.println();
        }
        rs.close();
        statement.close();
        connection.close();

    }
}


