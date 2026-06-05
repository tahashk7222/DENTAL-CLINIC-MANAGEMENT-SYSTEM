package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dental_clinic",
                    "root",
                    "7222629"
            );

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {

            System.out.println(e);

        }

        return con;
    }
}