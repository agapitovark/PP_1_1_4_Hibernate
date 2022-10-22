package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util implements AutoCloseable {

    private static volatile Util instance;


    private static final String DB_URL = "jdbc:mysql://localhost:3306/myschema";
    private static final String DB_PASSWORD = "root";
    private static final String DB_USERNAME = "root";
    public static Util getInstance() {
        Util localInstance = instance;
        if (localInstance == null) {
            synchronized (Util.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Util();
                }
            }
        }
        return localInstance;
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            System.out.println("Connection succeed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        } return connection;
    }

    @Override
    public void close() throws Exception {

    }
}
