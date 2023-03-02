import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connectionName = DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","password");

        Statement stmt = connectionName.createStatement();

        stmt.execute("CREATE TABLE IF NOT EXISTS teacher(\n" +
                "teacher_id INTEGER NOT NULL AUTO_INCREMENT,\n" +
                "first_name TEXT NOT NULL,\n" +
                "last_name TEXT NOT NULL,\n" +
                "PRIMARY KEY(teacher_id)\n" +
                ");\n");

        stmt.execute("SHOW TABLES;");
        ResultSet rs = stmt.getResultSet();

        while(rs!=null && rs.next())
            System.out.println(rs.getString(1));

        connectionName.close();
    }

}
